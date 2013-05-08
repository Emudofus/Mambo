

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AchievementListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6205;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] finishedAchievementsIds;
    public AchievementRewardable[] rewardableAchievements;
    
    public AchievementListMessage() { }
    
    public AchievementListMessage(short[] finishedAchievementsIds, AchievementRewardable[] rewardableAchievements) {
        this.finishedAchievementsIds = finishedAchievementsIds;
        this.rewardableAchievements = rewardableAchievements;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(finishedAchievementsIds.length);
        for (short entry : finishedAchievementsIds) {
            buf.writeShort(entry);
        }
        buf.writeUShort(rewardableAchievements.length);
        for (AchievementRewardable entry : rewardableAchievements) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        finishedAchievementsIds = new short[limit];
        for (int i = 0; i < limit; i++) {
            finishedAchievementsIds[i] = buf.readShort();
        }
        limit = buf.readUShort();
        rewardableAchievements = new AchievementRewardable[limit];
        for (int i = 0; i < limit; i++) {
            rewardableAchievements[i] = new AchievementRewardable();
            rewardableAchievements[i].deserialize(buf);
        }
    }
    
}
