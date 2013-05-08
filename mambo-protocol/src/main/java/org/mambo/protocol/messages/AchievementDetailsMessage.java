

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AchievementDetailsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6378;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public Achievement achievement;
    
    public AchievementDetailsMessage() { }
    
    public AchievementDetailsMessage(Achievement achievement) {
        this.achievement = achievement;
    }
    
    @Override
    public void serialize(Buffer buf) {
        achievement.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        achievement = new Achievement();
        achievement.deserialize(buf);
    }
    
}
