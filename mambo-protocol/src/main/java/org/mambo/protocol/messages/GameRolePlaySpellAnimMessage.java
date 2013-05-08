

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlaySpellAnimMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6114;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int casterId;
    public short targetCellId;
    public short spellId;
    public byte spellLevel;
    
    public GameRolePlaySpellAnimMessage() { }
    
    public GameRolePlaySpellAnimMessage(int casterId, short targetCellId, short spellId, byte spellLevel) {
        this.casterId = casterId;
        this.targetCellId = targetCellId;
        this.spellId = spellId;
        this.spellLevel = spellLevel;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(casterId);
        buf.writeShort(targetCellId);
        buf.writeShort(spellId);
        buf.writeByte(spellLevel);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        casterId = buf.readInt();
        targetCellId = buf.readShort();
        if (targetCellId < 0 || targetCellId > 559)
            throw new RuntimeException("Forbidden value on targetCellId = " + targetCellId + ", it doesn't respect the following condition : targetCellId < 0 || targetCellId > 559");
        spellId = buf.readShort();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
        spellLevel = buf.readByte();
        if (spellLevel < 1 || spellLevel > 6)
            throw new RuntimeException("Forbidden value on spellLevel = " + spellLevel + ", it doesn't respect the following condition : spellLevel < 1 || spellLevel > 6");
    }
    
}
