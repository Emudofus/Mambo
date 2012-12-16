package org.mambo.shared.database.impl.converter;

import org.jetbrains.annotations.NotNull;
import org.joda.time.Instant;
import org.joda.time.ReadableInstant;
import org.mambo.shared.database.ColumnConverter;
import org.mambo.shared.database.DatabaseContext;
import org.mambo.shared.database.impl.internal.EntityField;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Map;

/**
* @author Blackrush
*         Mambo
*/
public class SqlTimestampToJodaInstant implements ColumnConverter {
    @Override
    public Object extract(@NotNull DatabaseContext ctx, @NotNull EntityField<?> field, @NotNull ResultSet rset) throws SQLException {
        Timestamp timestamp = rset.getTimestamp(field.getColumnName());
        return new Instant(timestamp.getTime());
    }

    @Override
    public void export(@NotNull DatabaseContext ctx, @NotNull EntityField<?> field, Object obj, @NotNull Map<String, Object> values) {
        Timestamp timestamp;
        if (obj == null) {
            timestamp = new Timestamp(0);
        } else if (obj instanceof ReadableInstant) {
            timestamp = new Timestamp(((ReadableInstant) obj).getMillis());
        } else return;

        values.put(field.getColumnName(), timestamp);
    }
}
