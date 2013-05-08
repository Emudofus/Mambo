

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MapNpcsQuestStatusUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5642;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int mapId;
    public int[] npcsIdsWithQuest;
    public GameRolePlayNpcQuestFlag[] questFlags;
    public int[] npcsIdsWithoutQuest;
    
    public MapNpcsQuestStatusUpdateMessage() { }
    
    public MapNpcsQuestStatusUpdateMessage(int mapId, int[] npcsIdsWithQuest, GameRolePlayNpcQuestFlag[] questFlags, int[] npcsIdsWithoutQuest) {
        this.mapId = mapId;
        this.npcsIdsWithQuest = npcsIdsWithQuest;
        this.questFlags = questFlags;
        this.npcsIdsWithoutQuest = npcsIdsWithoutQuest;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(mapId);
        buf.writeUShort(npcsIdsWithQuest.length);
        for (int entry : npcsIdsWithQuest) {
            buf.writeInt(entry);
        }
        buf.writeUShort(questFlags.length);
        for (GameRolePlayNpcQuestFlag entry : questFlags) {
            entry.serialize(buf);
        }
        buf.writeUShort(npcsIdsWithoutQuest.length);
        for (int entry : npcsIdsWithoutQuest) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        mapId = buf.readInt();
        int limit = buf.readUShort();
        npcsIdsWithQuest = new int[limit];
        for (int i = 0; i < limit; i++) {
            npcsIdsWithQuest[i] = buf.readInt();
        }
        limit = buf.readUShort();
        questFlags = new GameRolePlayNpcQuestFlag[limit];
        for (int i = 0; i < limit; i++) {
            questFlags[i] = new GameRolePlayNpcQuestFlag();
            questFlags[i].deserialize(buf);
        }
        limit = buf.readUShort();
        npcsIdsWithoutQuest = new int[limit];
        for (int i = 0; i < limit; i++) {
            npcsIdsWithoutQuest[i] = buf.readInt();
        }
    }
    
}
