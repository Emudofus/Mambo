

// Generated on 12/14/2012 18:44:21
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(immuneSpellId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        immuneSpellId = reader.readInt();
    }
    
}
