

// Generated on 01/04/2013 14:54:43
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AchievementStartedObjective extends AchievementObjective {
    public static final short TYPE_ID = 402;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short value;
    
    public AchievementStartedObjective() { }
    
    public AchievementStartedObjective(int id, short maxValue, short value) {
        super(id, maxValue);
        this.value = value;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(value);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        value = reader.readShort();
        if (value < 0)
            throw new RuntimeException("Forbidden value on value = " + value + ", it doesn't respect the following condition : value < 0");
    }
    
}
