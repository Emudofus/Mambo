

// Generated on 01/04/2013 14:54:31
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class QuestObjectiveValidationMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6085;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short questId;
    public short objectiveId;
    
    public QuestObjectiveValidationMessage() { }
    
    public QuestObjectiveValidationMessage(short questId, short objectiveId) {
        this.questId = questId;
        this.objectiveId = objectiveId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(questId);
        writer.writeShort(objectiveId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        questId = reader.readShort();
        if (questId < 0)
            throw new RuntimeException("Forbidden value on questId = " + questId + ", it doesn't respect the following condition : questId < 0");
        objectiveId = reader.readShort();
        if (objectiveId < 0)
            throw new RuntimeException("Forbidden value on objectiveId = " + objectiveId + ", it doesn't respect the following condition : objectiveId < 0");
    }
    
}
