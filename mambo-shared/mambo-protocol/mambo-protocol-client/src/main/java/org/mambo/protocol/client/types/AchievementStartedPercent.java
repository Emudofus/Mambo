

// Generated on 01/04/2013 14:54:43
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AchievementStartedPercent extends Achievement {
    public static final short TYPE_ID = 362;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte completionPercent;
    
    public AchievementStartedPercent() { }
    
    public AchievementStartedPercent(short id, AchievementObjective[] finishedObjective, AchievementStartedObjective[] startedObjectives, byte completionPercent) {
        super(id, finishedObjective, startedObjectives);
        this.completionPercent = completionPercent;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(completionPercent);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        completionPercent = reader.readByte();
        if (completionPercent < 0)
            throw new RuntimeException("Forbidden value on completionPercent = " + completionPercent + ", it doesn't respect the following condition : completionPercent < 0");
    }
    
}
