

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AbstractFightDispellableEffect extends NetworkType {
    public static final short TYPE_ID = 206;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int uid;
    public int targetId;
    public short turnDuration;
    public byte dispelable;
    public short spellId;
    public int parentBoostUid;
    
    public AbstractFightDispellableEffect() { }
    
    public AbstractFightDispellableEffect(int uid, int targetId, short turnDuration, byte dispelable, short spellId, int parentBoostUid) {
        this.uid = uid;
        this.targetId = targetId;
        this.turnDuration = turnDuration;
        this.dispelable = dispelable;
        this.spellId = spellId;
        this.parentBoostUid = parentBoostUid;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(uid);
        buf.writeInt(targetId);
        buf.writeShort(turnDuration);
        buf.writeByte(dispelable);
        buf.writeShort(spellId);
        buf.writeInt(parentBoostUid);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        uid = buf.readInt();
        if (uid < 0)
            throw new RuntimeException("Forbidden value on uid = " + uid + ", it doesn't respect the following condition : uid < 0");
        targetId = buf.readInt();
        turnDuration = buf.readShort();
        dispelable = buf.readByte();
        if (dispelable < 0)
            throw new RuntimeException("Forbidden value on dispelable = " + dispelable + ", it doesn't respect the following condition : dispelable < 0");
        spellId = buf.readShort();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
        parentBoostUid = buf.readInt();
        if (parentBoostUid < 0)
            throw new RuntimeException("Forbidden value on parentBoostUid = " + parentBoostUid + ", it doesn't respect the following condition : parentBoostUid < 0");
    }
    
}
