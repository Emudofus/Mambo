

// Generated on 12/14/2012 18:44:10
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class QuestListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5626;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] finishedQuestsIds;
    public short[] finishedQuestsCounts;
    public QuestActiveInformations[] activeQuests;
    
    public QuestListMessage() { }
    
    public QuestListMessage(short[] finishedQuestsIds, short[] finishedQuestsCounts, QuestActiveInformations[] activeQuests) {
        this.finishedQuestsIds = finishedQuestsIds;
        this.finishedQuestsCounts = finishedQuestsCounts;
        this.activeQuests = activeQuests;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(finishedQuestsIds.length);
        for (short entry : finishedQuestsIds) {
            writer.writeShort(entry);
        }
        writer.writeUnsignedShort(finishedQuestsCounts.length);
        for (short entry : finishedQuestsCounts) {
            writer.writeShort(entry);
        }
        writer.writeUnsignedShort(activeQuests.length);
        for (QuestActiveInformations entry : activeQuests) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        finishedQuestsIds = new short[limit];
        for (int i = 0; i < limit; i++) {
            finishedQuestsIds[i] = reader.readShort();
        }
        limit = reader.readUnsignedShort();
        finishedQuestsCounts = new short[limit];
        for (int i = 0; i < limit; i++) {
            finishedQuestsCounts[i] = reader.readShort();
        }
        limit = reader.readUnsignedShort();
        activeQuests = new QuestActiveInformations[limit];
        for (int i = 0; i < limit; i++) {
            activeQuests[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), QuestActiveInformations.class);
            activeQuests[i].deserialize(reader);
        }
    }
    
}
