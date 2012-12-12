package org.mambo.shared.database;

import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author Blackrush
 *         Mambo
 */
public interface ColumnConverter {
    /**
     * extract values from a {@link ResultSet}
     * @param ctx current context
     * @param rset values to extract
     * @return extracted value
     * @throws SQLException
     */
    Object extract(@NotNull DatabaseContext ctx, @NotNull ResultSet rset) throws SQLException;

    /**
     * export value to a {@link Map}
     * @param ctx current context
     * @param obj value to export
     * @param values exported values
     */
    void export(@NotNull DatabaseContext ctx, @NotNull Object obj, @NotNull Map<String, Object> values);
}
