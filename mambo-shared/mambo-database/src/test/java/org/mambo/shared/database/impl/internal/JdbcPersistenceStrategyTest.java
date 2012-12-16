package org.mambo.shared.database.impl.internal;

import com.google.inject.util.Providers;
import org.jetbrains.annotations.NotNull;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mambo.shared.database.DatabaseContext;
import org.mambo.shared.database.MutableRepository;
import org.mambo.shared.database.annotations.Column;
import org.mambo.shared.database.annotations.Id;
import org.mambo.shared.database.annotations.Table;
import org.mambo.shared.database.impl.Model;
import org.mambo.shared.database.impl.SimpleMutableRepository;
import org.mambo.shared.database.persistence.JdbcPersistenceStrategy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author Blackrush
 *         Mambo
 */
public class JdbcPersistenceStrategyTest {

    @Table("my_mutable_entities")
    static class MyMutableEntity extends Model<MyMutableEntity> {
        @Column
        @Id
        private Long id = 0L;

        @Column
        private String value = "";

        @NotNull
        @Override
        public Long getId() {
            return id;
        }

        @Override
        public void setId(@NotNull Object id) {
            this.id = (Long) id;
        }

        @NotNull
        public String getValue() {
            return value;
        }

        public void setValue(@NotNull String value) {
            this.value = value;
        }
    }

    private Connection connection;
    private DatabaseContext ctx;
    private JdbcPersistenceStrategy persistenceStrategy;
    private MutableRepository<MyMutableEntity> repository;

    private void createSchema() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("CREATE SCHEMA `test_db`;");
        statement.close();

        connection.setCatalog("test_db");
    }

    private void createTablesAndInsertData() throws SQLException {
        Statement statement = connection.createStatement();

        statement.execute("DROP TABLE IF EXISTS `my_mutable_entities`;");
        statement.execute("CREATE TABLE `my_mutable_entities`(" +
                          "`id`  bigint NOT NULL, " +
                          "`value`  varchar(255) NOT NULL, " +
                          "`created_at` datetime NOT NULL, " +
                          "`persisted_at` datetime NOT NULL, " +
                          "PRIMARY KEY (`id`));");

        statement.execute("INSERT INTO `my_mutable_entities`(`id`, `value`, `created_at`, `persisted_at`) VALUES" +
                          "(1, 'first entity', NOW(), NOW()), " +
                          "(2, 'second entity', NOW(), NOW()), " +
                          "(3, 'third entity', NOW(), NOW());");

        statement.close();
    }

    private void clearTablesAndDeleteData() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE `my_mutable_entities`;");
        statement.execute("DROP SCHEMA `test_db`;");
        statement.close();
    }

    @Before
    public void setUp() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost");
        createSchema();
        createTablesAndInsertData();

        persistenceStrategy = new JdbcPersistenceStrategy(Providers.of(connection));
        ctx = new DatabaseContext(persistenceStrategy);
        repository = new SimpleMutableRepository<MyMutableEntity>(ctx, MyMutableEntity.class);

        ctx.register(repository);
    }

    @After
    public void tearDown() throws SQLException {
        clearTablesAndDeleteData();
        connection.close();
    }

    @Test
    public void load() {
        Set<MyMutableEntity> result = persistenceStrategy.load(ctx, repository.getEntityMetadata());
        assertThat(result.size(), is(3));

        for (MyMutableEntity entity : result) {
            assertThat(repository.isPersisted(entity), is(false)); // we have not loaded the repository
            assertThat(entity.getCreatedAt(), notNullValue());
            assertThat(entity.getPersistedAt(), notNullValue());
            assertThat(entity.getDeletedAt(), nullValue());
        }
    }

    @Test
    public void insert() {
        repository.load();
        MyMutableEntity entity = repository.createEmpty();
        entity.setValue("Hello world!");
        entity.setCreatedAt(Instant.now().plus(Duration.standardHours(5)));

        assertThat(repository.isPersisted(entity), is(false));
        assertThat(entity.getPersistedAt(), nullValue());

        repository.persist(entity);

        assertThat(repository.isPersisted(entity), is(true));
        //assertThat(entity.getPersistedAt(), notNullValue());
    }

    @Test
    public void update() {
        repository.load();
        MyMutableEntity entity = repository.find(1L);
        Instant oldPersistedAt = entity.getPersistedAt();
        assertThat(entity, notNullValue());
        assertThat(repository.isPersisted(entity), is(true));

        entity.setValue("My updated entity (" + DateTime.now() + ")");
        repository.persist(entity);

        assertThat(repository.isPersisted(entity), is(true));
        //assertThat(oldPersistedAt.isBefore(entity.getPersistedAt()), is(true));
    }

    @Test
    public void delete() {
        repository.load();
        MyMutableEntity entity = repository.find(2L);
        assertThat(entity.getDeletedAt(), nullValue());
        assertThat(repository.isPersisted(entity), is(true));

        repository.delete(entity);

        //assertThat(entity.getDeletedAt(), notNullValue());
        assertThat(repository.isPersisted(entity), is(false));
    }
}
