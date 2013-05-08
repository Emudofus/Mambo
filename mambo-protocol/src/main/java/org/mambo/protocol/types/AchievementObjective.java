

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AchievementObjective extends NetworkType {
    public static final short TYPE_ID = 404;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeInt(id);
        buf.writeShort(maxValue);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        id = buf.readInt();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
        maxValue = buf.readShort();
        if (maxValue < 0)
            throw new RuntimeException("Forbidden value on maxValue = " + maxValue + ", it doesn't respect the following condition : maxValue < 0");
    }
    
}
