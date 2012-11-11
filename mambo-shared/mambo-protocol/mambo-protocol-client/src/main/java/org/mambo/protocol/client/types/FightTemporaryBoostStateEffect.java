

// Generated on 11/11/2012 19:06:11
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class FightTemporaryBoostStateEffect extends FightTemporaryBoostEffect {
    public static final short TYPE_ID = 214;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short stateId;
    
    public FightTemporaryBoostStateEffect() { }
    
    public FightTemporaryBoostStateEffect(int uid, int targetId, short turnDuration, byte dispelable, short spellId, int parentBoostUid, short delta, short stateId) {
        super(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid, delta);
        this.stateId = stateId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(stateId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        stateId = reader.readShort();
    }
    
}
