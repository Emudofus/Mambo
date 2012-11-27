

// Generated on 11/11/2012 20:41:38
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AbstractFightDispellableEffect implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 206;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(uid);
        writer.writeInt(targetId);
        writer.writeShort(turnDuration);
        writer.writeByte(dispelable);
        writer.writeShort(spellId);
        writer.writeInt(parentBoostUid);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        uid = reader.readInt();
        if (uid < 0)
            throw new RuntimeException("Forbidden value on uid = " + uid + ", it doesn't respect the following condition : uid < 0");
        targetId = reader.readInt();
        turnDuration = reader.readShort();
        dispelable = reader.readByte();
        if (dispelable < 0)
            throw new RuntimeException("Forbidden value on dispelable = " + dispelable + ", it doesn't respect the following condition : dispelable < 0");
        spellId = reader.readShort();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
        parentBoostUid = reader.readInt();
        if (parentBoostUid < 0)
            throw new RuntimeException("Forbidden value on parentBoostUid = " + parentBoostUid + ", it doesn't respect the following condition : parentBoostUid < 0");
    }
    
}
