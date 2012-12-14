

// Generated on 12/14/2012 18:44:21
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(delta);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        delta = reader.readShort();
    }
    
}
