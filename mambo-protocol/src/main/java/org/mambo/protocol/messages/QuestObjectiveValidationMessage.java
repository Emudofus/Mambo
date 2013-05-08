

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeShort(questId);
        buf.writeShort(objectiveId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        questId = buf.readShort();
        if (questId < 0)
            throw new RuntimeException("Forbidden value on questId = " + questId + ", it doesn't respect the following condition : questId < 0");
        objectiveId = buf.readShort();
        if (objectiveId < 0)
            throw new RuntimeException("Forbidden value on objectiveId = " + objectiveId + ", it doesn't respect the following condition : objectiveId < 0");
    }
    
}
