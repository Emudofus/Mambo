

// Generated on 12/14/2012 18:44:21
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AchievementStartedValue extends Achievement {
    public static final short TYPE_ID = 361;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short value;
    public short maxValue;
    
    public AchievementStartedValue() { }
    
    public AchievementStartedValue(short id, AchievementObjective[] finishedObjective, AchievementStartedObjective[] startedObjectives, short value, short maxValue) {
        super(id, finishedObjective, startedObjectives);
        this.value = value;
        this.maxValue = maxValue;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(value);
        writer.writeShort(maxValue);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        value = reader.readShort();
        if (value < 0)
            throw new RuntimeException("Forbidden value on value = " + value + ", it doesn't respect the following condition : value < 0");
        maxValue = reader.readShort();
        if (maxValue < 0)
            throw new RuntimeException("Forbidden value on maxValue = " + maxValue + ", it doesn't respect the following condition : maxValue < 0");
    }
    
}
