

// Generated on 01/04/2013 14:54:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AchievementDetailsRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6380;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short achievementId;
    
    public AchievementDetailsRequestMessage() { }
    
    public AchievementDetailsRequestMessage(short achievementId) {
        this.achievementId = achievementId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(achievementId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        achievementId = reader.readShort();
        if (achievementId < 0)
            throw new RuntimeException("Forbidden value on achievementId = " + achievementId + ", it doesn't respect the following condition : achievementId < 0");
    }
    
}
