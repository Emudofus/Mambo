

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeUShort(questId);
        buf.writeUShort(stepId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        questId = buf.readUShort();
        if (questId < 0 || questId > 65535)
            throw new RuntimeException("Forbidden value on questId = " + questId + ", it doesn't respect the following condition : questId < 0 || questId > 65535");
        stepId = buf.readUShort();
        if (stepId < 0 || stepId > 65535)
            throw new RuntimeException("Forbidden value on stepId = " + stepId + ", it doesn't respect the following condition : stepId < 0 || stepId > 65535");
    }
    
}
