

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FightTemporaryBoostEffect extends AbstractFightDispellableEffect {
    public static final short TYPE_ID = 209;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short delta;
    
    public FightTemporaryBoostEffect() { }
    
    public FightTemporaryBoostEffect(int uid, int targetId, short turnDuration, byte dispelable, short spellId, int parentBoostUid, short delta) {
        super(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid);
        this.delta = delta;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(delta);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        delta = buf.readShort();
    }
    
}
