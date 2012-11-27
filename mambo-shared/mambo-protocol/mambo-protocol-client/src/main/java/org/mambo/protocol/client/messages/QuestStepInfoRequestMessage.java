

// Generated on 11/11/2012 20:41:30
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class QuestStepInfoRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5622;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int questId;
    
    public QuestStepInfoRequestMessage() { }
    
    public QuestStepInfoRequestMessage(int questId) {
        this.questId = questId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(questId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        questId = reader.readUnsignedShort();
        if (questId < 0 || questId > 65535)
            throw new RuntimeException("Forbidden value on questId = " + questId + ", it doesn't respect the following condition : questId < 0 || questId > 65535");
    }
    
}
