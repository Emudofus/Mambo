package org.mambo.shared.database;

import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 23:51
 */
public interface ColumnConverter {
    Object extract(@NotNull DatabaseContext ctx, @NotNull ResultSet rset) throws SQLException;
    void export(@NotNull DatabaseContext ctx, @NotNull Object obj, @NotNull Map<String, Object> rset) throws SQLException;
}
