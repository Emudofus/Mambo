package org.mambo.shared.database;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 20:01
 */
public interface ModelInterface<K> extends EntityInterface<K> {
    /**
     * @return true if exists in database
     */
    boolean isPersisted();

    /**
     * insert or update entity
     */
    void persist();

    /**
     * delete entity
     */
    void delete();
}
