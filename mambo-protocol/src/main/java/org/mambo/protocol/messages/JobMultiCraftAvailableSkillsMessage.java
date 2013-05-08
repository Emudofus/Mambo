

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(playerId);
        buf.writeUShort(skills.length);
        for (short entry : skills) {
            buf.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        playerId = buf.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        int limit = buf.readUShort();
        skills = new short[limit];
        for (int i = 0; i < limit; i++) {
            skills[i] = buf.readShort();
        }
    }
    
}
