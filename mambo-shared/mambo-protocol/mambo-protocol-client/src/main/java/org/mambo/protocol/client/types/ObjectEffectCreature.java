

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(monsterFamilyId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        monsterFamilyId = reader.readShort();
        if (monsterFamilyId < 0)
            throw new RuntimeException("Forbidden value on monsterFamilyId = " + monsterFamilyId + ", it doesn't respect the following condition : monsterFamilyId < 0");
    }
    
}
