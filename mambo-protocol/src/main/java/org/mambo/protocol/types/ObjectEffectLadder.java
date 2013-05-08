

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectEffectLadder extends ObjectEffectCreature {
    public static final short TYPE_ID = 81;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int monsterCount;
    
    public ObjectEffectLadder() { }
    
    public ObjectEffectLadder(short actionId, short monsterFamilyId, int monsterCount) {
        super(actionId, monsterFamilyId);
        this.monsterCount = monsterCount;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(monsterCount);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        monsterCount = buf.readInt();
        if (monsterCount < 0)
            throw new RuntimeException("Forbidden value on monsterCount = " + monsterCount + ", it doesn't respect the following condition : monsterCount < 0");
    }
    
}
