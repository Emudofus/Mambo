

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectEffectDuration extends ObjectEffect {
    public static final short TYPE_ID = 75;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short days;
    public short hours;
    public short minutes;
    
    public ObjectEffectDuration() { }
    
    public ObjectEffectDuration(short actionId, short days, short hours, short minutes) {
        super(actionId);
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(days);
        buf.writeShort(hours);
        buf.writeShort(minutes);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        days = buf.readShort();
        if (days < 0)
            throw new RuntimeException("Forbidden value on days = " + days + ", it doesn't respect the following condition : days < 0");
        hours = buf.readShort();
        if (hours < 0)
            throw new RuntimeException("Forbidden value on hours = " + hours + ", it doesn't respect the following condition : hours < 0");
        minutes = buf.readShort();
        if (minutes < 0)
            throw new RuntimeException("Forbidden value on minutes = " + minutes + ", it doesn't respect the following condition : minutes < 0");
    }
    
}
