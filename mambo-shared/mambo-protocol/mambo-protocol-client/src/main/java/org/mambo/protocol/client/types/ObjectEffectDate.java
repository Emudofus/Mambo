

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ObjectEffectDate extends ObjectEffect {
    public static final short TYPE_ID = 72;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short year;
    public short month;
    public short day;
    public short hour;
    public short minute;
    
    public ObjectEffectDate() { }
    
    public ObjectEffectDate(short actionId, short year, short month, short day, short hour, short minute) {
        super(actionId);
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(year);
        writer.writeShort(month);
        writer.writeShort(day);
        writer.writeShort(hour);
        writer.writeShort(minute);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        year = reader.readShort();
        if (year < 0)
            throw new RuntimeException("Forbidden value on year = " + year + ", it doesn't respect the following condition : year < 0");
        month = reader.readShort();
        if (month < 0)
            throw new RuntimeException("Forbidden value on month = " + month + ", it doesn't respect the following condition : month < 0");
        day = reader.readShort();
        if (day < 0)
            throw new RuntimeException("Forbidden value on day = " + day + ", it doesn't respect the following condition : day < 0");
        hour = reader.readShort();
        if (hour < 0)
            throw new RuntimeException("Forbidden value on hour = " + hour + ", it doesn't respect the following condition : hour < 0");
        minute = reader.readShort();
        if (minute < 0)
            throw new RuntimeException("Forbidden value on minute = " + minute + ", it doesn't respect the following condition : minute < 0");
    }
    
}
