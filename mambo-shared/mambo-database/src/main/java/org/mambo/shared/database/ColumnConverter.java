package org.mambo.shared.database;

import fi.evident.dalesbred.ResultTable;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 23:51
 */
public interface ColumnConverter {
    Object fromDatabase(ResultTable.ResultRow row);
    Object toDatabase(Object entity);
}
