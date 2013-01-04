

// Generated on 01/04/2013 14:54:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        achievement.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        achievement = new Achievement();
        achievement.deserialize(reader);
    }
    
}
