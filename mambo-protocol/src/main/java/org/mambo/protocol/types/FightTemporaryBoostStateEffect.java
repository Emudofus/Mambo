

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(stateId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        stateId = buf.readShort();
    }
    
}
