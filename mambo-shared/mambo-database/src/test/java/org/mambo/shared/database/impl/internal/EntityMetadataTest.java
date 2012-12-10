package org.mambo.shared.database.impl.internal;

import com.google.common.collect.Sets;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.mambo.shared.database.ColumnConverter;
import org.mambo.shared.database.DatabaseContext;
import org.mambo.shared.database.annotations.*;
import org.mambo.shared.database.impl.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 09/12/12
 * Time: 08:37
 */
public class EntityMetadataTest {
    static class ComplexDataConverter implements ColumnConverter {
        @Override
        public Object extract(@NotNull DatabaseContext ctx, @NotNull ResultSet rset) throws SQLException {
            return new ComplexData();
        }

        @Override
        public void export(@NotNull DatabaseContext ctx, @NotNull Object obj, @NotNull Map<String, Object> rset) throws SQLException {

        }
    }

    static class ComplexData {

    }

    @SuppressWarnings("unused")
    @Table("my_parent_model")
    static class MyParentModel extends Model<Long, MyParentModel> {
        @Column
        @Id
        private Long id = 0L;

        @Column
        @OneToMany(value = MyModel.class, mappedBy = "parent")
        private Set<MyModel> children = Sets.newHashSet();

        @NotNull
        @Override
        public Long getId() {
            return id;
        }

        @Override
        public void setId(@NotNull Long id) {
            this.id = id;
        }

        @NotNull
        public Set<MyModel> getChildren() {
            return children;
        }

        public void setChildren(@NotNull Set<MyModel> children) {
            this.children = children;
        }

        public void addChild(@NotNull MyModel child) {
            children.add(child);
        }
    }

    @SuppressWarnings("unused")
    @Table
    static class MyModel extends Model<Long, MyModel> {
        @Column
        @Id
        private Long id = 0L;

        @Column(name = "custom_name")
        private String value = "";

        @Column(name = "complex_data", converter = ComplexDataConverter.class)
        private ComplexData complexData;

        @Column
        @ManyToOne(targetField = "id")
        private MyParentModel parent; // in-database column name : parent_id

        @NotNull
        @Override
        public Long getId() {
            return id;
        }

        @Override
        public void setId(@NotNull Long id) {
            this.id = id;
        }

        @NotNull
        public String getValue() {
            return value;
        }

        public void setValue(@NotNull String value) {
            this.value = value;
        }

        public ComplexData getComplexData() {
            return complexData;
        }

        public void setComplexData(ComplexData complexData) {
            this.complexData = complexData;
        }

        public MyParentModel getParent() {
            return parent;
        }

        public void setParent(MyParentModel parent) {
            this.parent = parent;
        }
    }

    private EntityMetadata metadata;

    @Before
    public void createMetadata() {
        metadata = EntityMetadata.of(MyModel.class);
    }

    @Test
    public void tableName() {
        assertThat(metadata.getTableName(), is("mymodels"));
    }

    @Test
    public void primaryKey() {
        assertThat(metadata.getPrimaryKeyField().getColumnName(), is("id"));
        assertThat(metadata.getPrimaryKeyField().getType(), sameInstance((Class) Long.class));
    }

    @Test
    public void entityFields() {
        assertThat(metadata.getField("id"), notNullValue());
        assertThat(metadata.getField("custom_name"), notNullValue());
        assertThat(metadata.getField("complex_data"), notNullValue());
        assertThat(metadata.getField("complex_data").getConverter(), is(ComplexDataConverter.class));
        assertThat(metadata.getField("parent"), notNullValue());
        assertThat(metadata.getFields().size(), is(4));
    }

    @Test
    public void createEmpty() {
        assertThat(metadata.createEmpty(), is(MyModel.class));
    }
}
