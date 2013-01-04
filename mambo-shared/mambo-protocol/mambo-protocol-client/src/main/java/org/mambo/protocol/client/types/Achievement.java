

// Generated on 01/04/2013 14:54:43
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class Achievement implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 363;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short id;
    public AchievementObjective[] finishedObjective;
    public AchievementStartedObjective[] startedObjectives;
    
    public Achievement() { }
    
    public Achievement(short id, AchievementObjective[] finishedObjective, AchievementStartedObjective[] startedObjectives) {
        this.id = id;
        this.finishedObjective = finishedObjective;
        this.startedObjectives = startedObjectives;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(id);
        writer.writeUnsignedShort(finishedObjective.length);
        for (AchievementObjective entry : finishedObjective) {
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(startedObjectives.length);
        for (AchievementStartedObjective entry : startedObjectives) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readShort();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
        int limit = reader.readUnsignedShort();
        finishedObjective = new AchievementObjective[limit];
        for (int i = 0; i < limit; i++) {
            finishedObjective[i] = new AchievementObjective();
            finishedObjective[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        startedObjectives = new AchievementStartedObjective[limit];
        for (int i = 0; i < limit; i++) {
            startedObjectives[i] = new AchievementStartedObjective();
            startedObjectives[i].deserialize(reader);
        }
    }
    
}
