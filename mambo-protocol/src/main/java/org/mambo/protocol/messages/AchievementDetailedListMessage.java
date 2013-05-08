

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AchievementDetailedListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6358;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public Achievement[] startedAchievements;
    public Achievement[] finishedAchievements;
    
    public AchievementDetailedListMessage() { }
    
    public AchievementDetailedListMessage(Achievement[] startedAchievements, Achievement[] finishedAchievements) {
        this.startedAchievements = startedAchievements;
        this.finishedAchievements = finishedAchievements;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(startedAchievements.length);
        for (Achievement entry : startedAchievements) {
            entry.serialize(buf);
        }
        buf.writeUShort(finishedAchievements.length);
        for (Achievement entry : finishedAchievements) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        startedAchievements = new Achievement[limit];
        for (int i = 0; i < limit; i++) {
            startedAchievements[i] = new Achievement();
            startedAchievements[i].deserialize(buf);
        }
        limit = buf.readUShort();
        finishedAchievements = new Achievement[limit];
        for (int i = 0; i < limit; i++) {
            finishedAchievements[i] = new Achievement();
            finishedAchievements[i].deserialize(buf);
        }
    }
    
}
