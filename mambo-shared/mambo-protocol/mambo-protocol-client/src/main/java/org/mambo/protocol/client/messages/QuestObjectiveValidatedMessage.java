

// Generated on 01/04/2013 14:54:31
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class QuestObjectiveValidatedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6098;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int questId;
    public int objectiveId;
    
    public QuestObjectiveValidatedMessage() { }
    
    public QuestObjectiveValidatedMessage(int questId, int objectiveId) {
        this.questId = questId;
        this.objectiveId = objectiveId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(questId);
        writer.writeUnsignedShort(objectiveId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        questId = reader.readUnsignedShort();
        if (questId < 0 || questId > 65535)
            throw new RuntimeException("Forbidden value on questId = " + questId + ", it doesn't respect the following condition : questId < 0 || questId > 65535");
        objectiveId = reader.readUnsignedShort();
        if (objectiveId < 0 || objectiveId > 65535)
            throw new RuntimeException("Forbidden value on objectiveId = " + objectiveId + ", it doesn't respect the following condition : objectiveId < 0 || objectiveId > 65535");
    }
    
}
