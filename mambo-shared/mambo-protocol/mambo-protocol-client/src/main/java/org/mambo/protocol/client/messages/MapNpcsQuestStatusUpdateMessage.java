

// Generated on 11/11/2012 19:17:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(mapId);
        writer.writeUnsignedShort(npcsIdsWithQuest.length);
        for (int entry : npcsIdsWithQuest) {
            writer.writeInt(entry);
        }
        writer.writeUnsignedShort(questFlags.length);
        for (GameRolePlayNpcQuestFlag entry : questFlags) {
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(npcsIdsWithoutQuest.length);
        for (int entry : npcsIdsWithoutQuest) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        mapId = reader.readInt();
        int limit = reader.readUnsignedShort();
        npcsIdsWithQuest = new int[limit];
        for (int i = 0; i < limit; i++) {
            npcsIdsWithQuest[i] = reader.readInt();
        }
        limit = reader.readUnsignedShort();
        questFlags = new GameRolePlayNpcQuestFlag[limit];
        for (int i = 0; i < limit; i++) {
            questFlags[i] = new GameRolePlayNpcQuestFlag();
            questFlags[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        npcsIdsWithoutQuest = new int[limit];
        for (int i = 0; i < limit; i++) {
            npcsIdsWithoutQuest[i] = reader.readInt();
        }
    }
    
}
