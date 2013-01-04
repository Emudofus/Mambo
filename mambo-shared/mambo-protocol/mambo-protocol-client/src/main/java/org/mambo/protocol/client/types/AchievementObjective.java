

// Generated on 01/04/2013 14:54:43
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AchievementObjective implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 404;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int id;
    public short maxValue;
    
    public AchievementObjective() { }
    
    public AchievementObjective(int id, short maxValue) {
        this.id = id;
        this.maxValue = maxValue;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(id);
        writer.writeShort(maxValue);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readInt();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
        maxValue = reader.readShort();
        if (maxValue < 0)
            throw new RuntimeException("Forbidden value on maxValue = " + maxValue + ", it doesn't respect the following condition : maxValue < 0");
    }
    
}
