

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FightTemporarySpellImmunityEffect extends AbstractFightDispellableEffect {
    public static final short TYPE_ID = 366;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int immuneSpellId;
    
    public FightTemporarySpellImmunityEffect() { }
    
    public FightTemporarySpellImmunityEffect(int uid, int targetId, short turnDuration, byte dispelable, short spellId, int parentBoostUid, int immuneSpellId) {
        super(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid);
        this.immuneSpellId = immuneSpellId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(immuneSpellId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        immuneSpellId = buf.readInt();
    }
    
}
