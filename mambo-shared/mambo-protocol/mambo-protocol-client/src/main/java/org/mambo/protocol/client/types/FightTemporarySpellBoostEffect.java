

// Generated on 11/11/2012 20:41:38
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class FightTemporarySpellBoostEffect extends FightTemporaryBoostEffect {
    public static final short TYPE_ID = 207;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short boostedSpellId;
    
    public FightTemporarySpellBoostEffect() { }
    
    public FightTemporarySpellBoostEffect(int uid, int targetId, short turnDuration, byte dispelable, short spellId, int parentBoostUid, short delta, short boostedSpellId) {
        super(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid, delta);
        this.boostedSpellId = boostedSpellId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(boostedSpellId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        boostedSpellId = reader.readShort();
        if (boostedSpellId < 0)
            throw new RuntimeException("Forbidden value on boostedSpellId = " + boostedSpellId + ", it doesn't respect the following condition : boostedSpellId < 0");
    }
    
}
