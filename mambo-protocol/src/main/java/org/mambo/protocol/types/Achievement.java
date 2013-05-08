

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class Achievement extends NetworkType {
    public static final short TYPE_ID = 363;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeShort(id);
        buf.writeUShort(finishedObjective.length);
        for (AchievementObjective entry : finishedObjective) {
            entry.serialize(buf);
        }
        buf.writeUShort(startedObjectives.length);
        for (AchievementStartedObjective entry : startedObjectives) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        id = buf.readShort();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
        int limit = buf.readUShort();
        finishedObjective = new AchievementObjective[limit];
        for (int i = 0; i < limit; i++) {
            finishedObjective[i] = new AchievementObjective();
            finishedObjective[i].deserialize(buf);
        }
        limit = buf.readUShort();
        startedObjectives = new AchievementStartedObjective[limit];
        for (int i = 0; i < limit; i++) {
            startedObjectives[i] = new AchievementStartedObjective();
            startedObjectives[i].deserialize(buf);
        }
    }
    
}
