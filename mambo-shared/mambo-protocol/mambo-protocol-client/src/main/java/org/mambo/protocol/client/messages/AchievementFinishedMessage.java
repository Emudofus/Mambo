

// Generated on 11/11/2012 19:16:57
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class AchievementFinishedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6208;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short achievementId;
    
    public AchievementFinishedMessage() { }
    
    public AchievementFinishedMessage(short achievementId) {
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
