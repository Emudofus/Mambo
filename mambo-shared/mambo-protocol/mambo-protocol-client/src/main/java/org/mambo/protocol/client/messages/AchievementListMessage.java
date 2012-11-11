

// Generated on 11/11/2012 19:16:57
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class AchievementListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6205;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public Achievement[] startedAchievements;
    public short[] finishedAchievementsIds;
    
    public AchievementListMessage() { }
    
    public AchievementListMessage(Achievement[] startedAchievements, short[] finishedAchievementsIds) {
        this.startedAchievements = startedAchievements;
        this.finishedAchievementsIds = finishedAchievementsIds;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(startedAchievements.length);
        for (Achievement entry : startedAchievements) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(finishedAchievementsIds.length);
        for (short entry : finishedAchievementsIds) {
            writer.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        startedAchievements = new Achievement[limit];
        for (int i = 0; i < limit; i++) {
            startedAchievements[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), Achievement.class);
            startedAchievements[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        finishedAchievementsIds = new short[limit];
        for (int i = 0; i < limit; i++) {
            finishedAchievementsIds[i] = reader.readShort();
        }
    }
    
}
