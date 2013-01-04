

// Generated on 01/04/2013 14:54:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AchievementRewardSuccessMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6376;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short achievementId;
    
    public AchievementRewardSuccessMessage() { }
    
    public AchievementRewardSuccessMessage(short achievementId) {
        this.achievementId = achievementId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(achievementId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        achievementId = reader.readShort();
    }
    
}
