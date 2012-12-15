package org.mambo.shared.database.impl.internal;

import com.google.common.base.Function;
import org.jetbrains.annotations.NotNull;
import org.joda.time.Instant;
import org.junit.Before;
import org.junit.Test;
import org.mambo.shared.database.DatabaseContext;
import org.mambo.shared.database.Entity;
import org.mambo.shared.database.MutableRepository;
import org.mambo.shared.database.Repository;
import org.mambo.shared.database.annotations.Column;
import org.mambo.shared.database.annotations.Id;
import org.mambo.shared.database.annotations.Table;
import org.mambo.shared.database.impl.Model;
import org.mambo.shared.database.impl.SimpleMutableRepository;
import org.mambo.shared.database.persistence.PersistenceStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author Blackrush
 *         Mambo
 */
public class RepositoryTest {
    @Table("my_models")
    static class MyModel extends Model<MyModel> {
        @Id
        @Column
        private Integer id = 0;

        @Column
        private String value = "";

        @NotNull
        @Override
        public Integer getId() {
            return id;
        }

        @Override
        public void setId(@NotNull Object id) {
            this.id = (Integer) id;
        }

        @NotNull
        public String getValue() {
            return value;
        }

        public void setValue(@NotNull String value) {
            this.value = value;
        }

        @Override
        public void setRepository(@NotNull MutableRepository<MyModel> repository) {
            super.setRepository(repository);
        }
    }

    class FakePersistenceStrategy implements PersistenceStrategy {
        private final Logger log = LoggerFactory.getLogger(FakePersistenceStrategy.class);

        private boolean loaded, inserted, updated, deleted;

        @NotNull
        @Override
        public <E extends Entity> Set<E> load(@NotNull DatabaseContext ctx, @NotNull EntityMetadata<E> metadata) {
            log.debug("load data");
            loaded = true;
            return Collections.singleton((E) instance);
        }

        @Override
        public <E extends Entity> void insert(@NotNull DatabaseContext ctx, @NotNull EntityMetadata<E> metadata, @NotNull E entity) {
            log.debug("insert data");
            inserted = true;
        }

        @Override
        public <E extends Entity> void update(@NotNull DatabaseContext ctx, @NotNull EntityMetadata<E> metadata, @NotNull E entity) {
            log.debug("update data");
            updated = true;
        }

        @Override
        public <E extends Entity> void delete(@NotNull DatabaseContext ctx, @NotNull EntityMetadata<E> metadata, @NotNull E entity) {
            log.debug("delete data");
            deleted = true;
        }
    }

    private MyModel instance;
    private FakePersistenceStrategy persistenceStrategy;
    private DatabaseContext ctx;

    @Before
    public void setUp() {
        persistenceStrategy = new FakePersistenceStrategy();

        ctx = new DatabaseContext(persistenceStrategy);

        final MutableRepository<MyModel> repository = ctx.register(
                new SimpleMutableRepository<MyModel>(ctx, MyModel.class));

        instance = repository.createWithValues(new Function<MyModel, Void>() {
            public Void apply(MyModel input) {
                input.setRepository(repository);
                input.setId(1);
                input.setValue("Hello world!");
                input.setPersistedAt(Instant.now());
                return null;
            }
        });

        ctx.get(MyModel.class).load();
    }

    @Test
    public void findById() {
        Repository<MyModel> repository = ctx.get(MyModel.class);
        MyModel result = repository.find(1);

        assertThat(result, is(instance));
    }

    @Test
    public void findByPropertyId() {
        Repository<MyModel> repository = ctx.get(MyModel.class);
        MyModel result = repository.find("id", 1);

        assertThat(result, is(instance));
    }

    @Test
    public void findByProperty() {
        Repository<MyModel> repository = ctx.get(MyModel.class);
        MyModel result = repository.find("value", "Hello world!");

        assertThat(result, is(instance));
    }

    @Test
    public void getReference() {
        Repository<MyModel> repository = ctx.get(MyModel.class);
        MyModel ref = repository.getReference(1);

        assertThat(ref, not(instance));
        assertThat(ref.getValue(), is(instance.getValue()));

        ref.setValue("Hello world! (modified)");
        assertThat(instance.getValue(), is("Hello world! (modified)"));
    }

    @Test
    public void instanceIsPersisted() {
        assertThat(instance.isPersisted(), is(true));
        assertThat(instance.getPersistedAt(), notNullValue());
    }

    @Test
    public void persistNewEntity() {
        final MutableRepository<MyModel> repository = ctx.getMutable(MyModel.class);

        MyModel newInstance = repository.createWithValues(new Function<MyModel, Void>() {
            @Override
            public Void apply(MyModel input) {
                input.setRepository(repository);
                input.setValue("Hello world! (2)");
                return null;
            }
        });

        assertThat(persistenceStrategy.inserted, is(false));
        assertThat(newInstance.isPersisted(), is(false));

        newInstance.persist();
        assertThat(persistenceStrategy.inserted, is(true));
        assertThat(newInstance.isPersisted(), is(true));
        assertThat(newInstance.getPersistedAt(), notNullValue());
        assertThat(newInstance.getId(), is(2));
    }

    @Test
    public void update() {
        instance.setValue("Hello world! (modified)");
        instance.persist();

        assertThat(persistenceStrategy.inserted, is(false));
        assertThat(persistenceStrategy.updated, is(true));
    }

    @Test
    public void delete() {
        instance.delete();

        assertThat(persistenceStrategy.deleted, is(true));
        assertThat(instance.getDeletedAt(), notNullValue());
    }
}
