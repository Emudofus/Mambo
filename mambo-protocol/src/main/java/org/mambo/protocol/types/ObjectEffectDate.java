

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(year);
        buf.writeShort(month);
        buf.writeShort(day);
        buf.writeShort(hour);
        buf.writeShort(minute);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        year = buf.readShort();
        if (year < 0)
            throw new RuntimeException("Forbidden value on year = " + year + ", it doesn't respect the following condition : year < 0");
        month = buf.readShort();
        if (month < 0)
            throw new RuntimeException("Forbidden value on month = " + month + ", it doesn't respect the following condition : month < 0");
        day = buf.readShort();
        if (day < 0)
            throw new RuntimeException("Forbidden value on day = " + day + ", it doesn't respect the following condition : day < 0");
        hour = buf.readShort();
        if (hour < 0)
            throw new RuntimeException("Forbidden value on hour = " + hour + ", it doesn't respect the following condition : hour < 0");
        minute = buf.readShort();
        if (minute < 0)
            throw new RuntimeException("Forbidden value on minute = " + minute + ", it doesn't respect the following condition : minute < 0");
    }
    
}
