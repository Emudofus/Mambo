

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(days);
        writer.writeShort(hours);
        writer.writeShort(minutes);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        days = reader.readShort();
        if (days < 0)
            throw new RuntimeException("Forbidden value on days = " + days + ", it doesn't respect the following condition : days < 0");
        hours = reader.readShort();
        if (hours < 0)
            throw new RuntimeException("Forbidden value on hours = " + hours + ", it doesn't respect the following condition : hours < 0");
        minutes = reader.readShort();
        if (minutes < 0)
            throw new RuntimeException("Forbidden value on minutes = " + minutes + ", it doesn't respect the following condition : minutes < 0");
    }
    
}
