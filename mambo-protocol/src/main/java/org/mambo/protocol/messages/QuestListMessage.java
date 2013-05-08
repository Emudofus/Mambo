

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(finishedQuestsIds.length);
        for (short entry : finishedQuestsIds) {
            buf.writeShort(entry);
        }
        buf.writeUShort(finishedQuestsCounts.length);
        for (short entry : finishedQuestsCounts) {
            buf.writeShort(entry);
        }
        buf.writeUShort(activeQuests.length);
        for (QuestActiveInformations entry : activeQuests) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        finishedQuestsIds = new short[limit];
        for (int i = 0; i < limit; i++) {
            finishedQuestsIds[i] = buf.readShort();
        }
        limit = buf.readUShort();
        finishedQuestsCounts = new short[limit];
        for (int i = 0; i < limit; i++) {
            finishedQuestsCounts[i] = buf.readShort();
        }
        limit = buf.readUShort();
        activeQuests = new QuestActiveInformations[limit];
        for (int i = 0; i < limit; i++) {
            activeQuests[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            activeQuests[i].deserialize(buf);
        }
    }
    
}
