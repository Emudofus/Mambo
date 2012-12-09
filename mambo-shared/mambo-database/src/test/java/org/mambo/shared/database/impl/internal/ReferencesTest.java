package org.mambo.shared.database.impl.internal;

import com.google.common.base.Supplier;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.mambo.shared.database.EntityInterface;
import org.mambo.shared.database.Repository;
import org.mambo.shared.database.annotations.Column;
import org.mambo.shared.database.annotations.Id;
import org.mambo.shared.database.annotations.Table;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 09/12/12
 * Time: 10:46
 */
public class ReferencesTest {
    static class FakeRepository<E extends EntityInterface<?>> implements Repository<E> {
        final E instance;
        final EntityMetadata metadata;

        FakeRepository(E instance) {
            this.instance = instance;
            this.metadata = EntityMetadata.of(instance.getClass());
        }

        EntityMetadata getMetadata() {
            return metadata;
        }

        @Override
        public E find(Object id) {
            return instance;
        }

        @Override
        public E find(String property, Object value) {
            return instance;
        }
    }

    @Table("my_models")
    static class MyModel implements EntityInterface<Integer> {
        @Id
        @Column
        private Integer id = 0;

        @NotNull
        @Override
        public Integer getId() {
            return id;
        }

        @Override
        public void setId(@NotNull Integer id) {
            this.id = id;
        }
    }

    private MyModel instance;
    private FakeRepository<MyModel> repository;

    private MyModel reference() {
        return References.create(repository, repository.getMetadata(), instance.getId());
    }

    private Supplier<MyModel> supplier() {
        return new Supplier<MyModel>() {
            @Override
            public MyModel get() {
                return instance;
            }
        };
    }

    @Before
    public void createInstanceAndRepository() {
        instance = new MyModel();
        repository = new FakeRepository<MyModel>(instance);
    }

    @Test
    public void create() {
        MyModel ref = reference();

        assertThat(ref, not(instance));
    }

    @Test
    public void callMethod() {
        MyModel ref = reference();

        ref.setId(1);
        assertThat(instance.getId(), is(1));
    }

    @Test
    public void setField() {
        MyModel ref = reference();

        ref.id = 1;
        assertThat(instance.getId(), not(1));
    }

    @Test
    public void supplierTest() {
        Supplier<MyModel> supplier = supplier();
        MyModel ref = References.of(MyModel.class, supplier);
        assertThat(ref, not(supplier.get()));

        ref.setId(1);
        assertThat(supplier.get().getId(), is(1));
    }

    @Test
    public void withMetadata() {
        MyModel ref = reference();

        EntityMetadata metadata = repository.getMetadata();
        metadata.getField("id").set(ref, 1);

        assertThat(ref.getId(), is(1));
        assertThat(instance.getId(), is(1));

        assertThat(metadata.getField("id").get(ref), is(metadata.getField("id").get(instance)));
    }
}
