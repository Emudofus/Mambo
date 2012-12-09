package org.mambo.shared.database;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 19:54
 */
public interface Repository<E extends EntityInterface<?>> {
    E find(Object id);
    E find(String property, Object value);
}
