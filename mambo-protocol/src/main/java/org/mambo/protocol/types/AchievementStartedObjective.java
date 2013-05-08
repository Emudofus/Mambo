

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(value);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        value = buf.readShort();
        if (value < 0)
            throw new RuntimeException("Forbidden value on value = " + value + ", it doesn't respect the following condition : value < 0");
    }
    
}
