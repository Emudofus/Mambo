

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeShort(achievementId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        achievementId = buf.readShort();
        if (achievementId < 0)
            throw new RuntimeException("Forbidden value on achievementId = " + achievementId + ", it doesn't respect the following condition : achievementId < 0");
    }
    
}
