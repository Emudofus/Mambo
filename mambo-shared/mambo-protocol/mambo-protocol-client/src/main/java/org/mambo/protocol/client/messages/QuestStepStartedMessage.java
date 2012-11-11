

// Generated on 11/11/2012 19:17:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class QuestStepStartedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6096;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int questId;
    public int stepId;
    
    public QuestStepStartedMessage() { }
    
    public QuestStepStartedMessage(int questId, int stepId) {
        this.questId = questId;
        this.stepId = stepId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(questId);
        writer.writeUnsignedShort(stepId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        questId = reader.readUnsignedShort();
        if (questId < 0 || questId > 65535)
            throw new RuntimeException("Forbidden value on questId = " + questId + ", it doesn't respect the following condition : questId < 0 || questId > 65535");
        stepId = reader.readUnsignedShort();
        if (stepId < 0 || stepId > 65535)
            throw new RuntimeException("Forbidden value on stepId = " + stepId + ", it doesn't respect the following condition : stepId < 0 || stepId > 65535");
    }
    
}
