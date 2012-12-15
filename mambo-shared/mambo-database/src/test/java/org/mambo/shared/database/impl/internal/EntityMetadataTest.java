package org.mambo.shared.database.impl.internal;

import com.google.common.collect.Lists;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.mambo.shared.database.ColumnConverter;
import org.mambo.shared.database.DatabaseContext;
import org.mambo.shared.database.Entity;
import org.mambo.shared.database.annotations.*;
import org.mambo.shared.database.impl.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
        public void export(@NotNull DatabaseContext ctx, @NotNull Object obj, @NotNull Map<String, Object> values) {

        }
    }

    static class ComplexData {

    }

    @SuppressWarnings("unused")
    @Table("my_parent_model")
    static class MyParentModel implements Entity {
        @Column
        @Id
        private Long id = 0L;

        @Column
        @OneToMany(mappedBy = "parent")
        private List<MyModel> children = Lists.newArrayList();

        @NotNull
        @Override
        public Long getId() {
            return id;
        }

        @NotNull
        public List<MyModel> getChildren() {
            return children;
        }
    }

    @SuppressWarnings("unused")
    @Table
    @ColumnOverrides({
            @ColumnOverride(name = "persisted_at", by = @Column(name = "updated_at"))
    })
    static class MyModel extends Model<MyModel> {
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

    private EntityMetadata<MyModel> metadata;

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
        assertThat(metadata.getField("created_at"), notNullValue());
        assertThat(metadata.getField("updated_at"), notNullValue());
        assertThat(metadata.getFields().size(), is(6));
    }

    @Test
    public void createEmpty() {
        assertThat(metadata.createEmpty(), instanceOf(MyModel.class));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setImmutableProperty() {
        EntityMetadata<MyParentModel> metadata = EntityMetadata.of(MyParentModel.class);
        MyParentModel model = new MyParentModel();

        metadata.getField("id").set(model, 1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void instantiateImmutableEntity() {
        EntityMetadata<MyParentModel> metadata = EntityMetadata.of(MyParentModel.class);
        metadata.createEmpty();
    }

    @Test
    public void oneToMany() {
        EntityMetadata<MyParentModel> parent = EntityMetadata.of(MyParentModel.class);

        EntityField<MyParentModel> field = parent.getField("children");
        assertThat(field, notNullValue());
        assertThat(field.getConverter(), is(Dependency.class));

        @SuppressWarnings("unchecked")
        Dependency<MyParentModel> dependency = (Dependency<MyParentModel>) field.getConverter();
        assertThat(dependency.getType(), is(Dependency.Type.ONE_TO_MANY));
        assertThat(dependency.getTo().getEntityClass(), sameInstance((Class) MyModel.class));
        assertThat(dependency.getTriggerProperty(), is("parent"));
    }

    @Test
    public void manyToOne() {
        EntityField<MyModel> field = metadata.getField("parent");
        assertThat(field, notNullValue());
        assertThat(field.getConverter(), is(Dependency.class));

        Dependency dependency = (Dependency) field.getConverter();
        assertThat(dependency.getType(), is(Dependency.Type.MANY_TO_ONE));
        assertThat((Class) dependency.getTo().getEntityClass(), sameInstance((Class) MyParentModel.class));
        assertThat(dependency.getTriggerProperty(), is("id"));
    }
}
