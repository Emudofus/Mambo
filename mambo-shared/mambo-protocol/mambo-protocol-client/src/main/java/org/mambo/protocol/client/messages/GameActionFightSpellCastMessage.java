

// Generated on 11/11/2012 20:41:23
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class GameActionFightSpellCastMessage extends AbstractGameActionFightTargetedAbilityMessage {
    public static final int MESSAGE_ID = 1010;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short spellId;
    public byte spellLevel;
    
    public GameActionFightSpellCastMessage() { }
    
    public GameActionFightSpellCastMessage(short actionId, int sourceId, int targetId, short destinationCellId, byte critical, boolean silentCast, short spellId, byte spellLevel) {
        super(actionId, sourceId, targetId, destinationCellId, critical, silentCast);
        this.spellId = spellId;
        this.spellLevel = spellLevel;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(spellId);
        writer.writeByte(spellLevel);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        spellId = reader.readShort();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
        spellLevel = reader.readByte();
        if (spellLevel < 1 || spellLevel > 6)
            throw new RuntimeException("Forbidden value on spellLevel = " + spellLevel + ", it doesn't respect the following condition : spellLevel < 1 || spellLevel > 6");
    }
    
}
