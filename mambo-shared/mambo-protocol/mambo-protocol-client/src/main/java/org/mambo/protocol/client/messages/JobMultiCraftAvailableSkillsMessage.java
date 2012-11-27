

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class JobMultiCraftAvailableSkillsMessage extends JobAllowMultiCraftRequestMessage {
    public static final int MESSAGE_ID = 5747;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int playerId;
    public short[] skills;
    
    public JobMultiCraftAvailableSkillsMessage() { }
    
    public JobMultiCraftAvailableSkillsMessage(boolean enabled, int playerId, short[] skills) {
        super(enabled);
        this.playerId = playerId;
        this.skills = skills;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(playerId);
        writer.writeUnsignedShort(skills.length);
        for (short entry : skills) {
            writer.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        playerId = reader.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        int limit = reader.readUnsignedShort();
        skills = new short[limit];
        for (int i = 0; i < limit; i++) {
            skills[i] = reader.readShort();
        }
    }
    
}
