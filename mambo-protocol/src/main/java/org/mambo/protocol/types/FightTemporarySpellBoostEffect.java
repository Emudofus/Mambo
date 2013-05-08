

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(boostedSpellId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        boostedSpellId = buf.readShort();
        if (boostedSpellId < 0)
            throw new RuntimeException("Forbidden value on boostedSpellId = " + boostedSpellId + ", it doesn't respect the following condition : boostedSpellId < 0");
    }
    
}
