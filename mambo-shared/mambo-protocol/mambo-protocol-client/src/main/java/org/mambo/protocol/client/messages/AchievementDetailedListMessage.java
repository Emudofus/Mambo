

// Generated on 01/04/2013 14:54:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(startedAchievements.length);
        for (Achievement entry : startedAchievements) {
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(finishedAchievements.length);
        for (Achievement entry : finishedAchievements) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        startedAchievements = new Achievement[limit];
        for (int i = 0; i < limit; i++) {
            startedAchievements[i] = new Achievement();
            startedAchievements[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        finishedAchievements = new Achievement[limit];
        for (int i = 0; i < limit; i++) {
            finishedAchievements[i] = new Achievement();
            finishedAchievements[i].deserialize(reader);
        }
    }
    
}
