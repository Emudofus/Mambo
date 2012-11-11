

// Generated on 11/11/2012 19:06:13
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(monsterCount);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        monsterCount = reader.readInt();
        if (monsterCount < 0)
            throw new RuntimeException("Forbidden value on monsterCount = " + monsterCount + ", it doesn't respect the following condition : monsterCount < 0");
    }
    
}
