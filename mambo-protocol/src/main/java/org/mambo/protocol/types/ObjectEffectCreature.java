

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectEffectCreature extends ObjectEffect {
    public static final short TYPE_ID = 71;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short monsterFamilyId;
    
    public ObjectEffectCreature() { }
    
    public ObjectEffectCreature(short actionId, short monsterFamilyId) {
        super(actionId);
        this.monsterFamilyId = monsterFamilyId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(monsterFamilyId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        monsterFamilyId = buf.readShort();
        if (monsterFamilyId < 0)
            throw new RuntimeException("Forbidden value on monsterFamilyId = " + monsterFamilyId + ", it doesn't respect the following condition : monsterFamilyId < 0");
    }
    
}
