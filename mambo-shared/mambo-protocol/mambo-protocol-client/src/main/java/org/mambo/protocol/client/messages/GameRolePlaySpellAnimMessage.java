

// Generated on 01/04/2013 14:54:31
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(casterId);
        writer.writeShort(targetCellId);
        writer.writeShort(spellId);
        writer.writeByte(spellLevel);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        casterId = reader.readInt();
        targetCellId = reader.readShort();
        if (targetCellId < 0 || targetCellId > 559)
            throw new RuntimeException("Forbidden value on targetCellId = " + targetCellId + ", it doesn't respect the following condition : targetCellId < 0 || targetCellId > 559");
        spellId = reader.readShort();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
        spellLevel = reader.readByte();
        if (spellLevel < 1 || spellLevel > 6)
            throw new RuntimeException("Forbidden value on spellLevel = " + spellLevel + ", it doesn't respect the following condition : spellLevel < 1 || spellLevel > 6");
    }
    
}
