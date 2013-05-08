

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(questId);
        buf.writeUShort(objectiveId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        questId = buf.readUShort();
        if (questId < 0 || questId > 65535)
            throw new RuntimeException("Forbidden value on questId = " + questId + ", it doesn't respect the following condition : questId < 0 || questId > 65535");
        objectiveId = buf.readUShort();
        if (objectiveId < 0 || objectiveId > 65535)
            throw new RuntimeException("Forbidden value on objectiveId = " + objectiveId + ", it doesn't respect the following condition : objectiveId < 0 || objectiveId > 65535");
    }
    
}
