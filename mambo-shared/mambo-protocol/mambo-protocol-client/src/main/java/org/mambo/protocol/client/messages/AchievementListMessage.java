

// Generated on 12/14/2012 18:44:02
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(finishedAchievementsIds.length);
        for (short entry : finishedAchievementsIds) {
            writer.writeShort(entry);
        }
        writer.writeUnsignedShort(rewardableAchievements.length);
        for (AchievementRewardable entry : rewardableAchievements) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        finishedAchievementsIds = new short[limit];
        for (int i = 0; i < limit; i++) {
            finishedAchievementsIds[i] = reader.readShort();
        }
        limit = reader.readUnsignedShort();
        rewardableAchievements = new AchievementRewardable[limit];
        for (int i = 0; i < limit; i++) {
            rewardableAchievements[i] = new AchievementRewardable();
            rewardableAchievements[i].deserialize(reader);
        }
    }
    
}
