

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class QuestStartRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5643;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int questId;
    
    public QuestStartRequestMessage() { }
    
    public QuestStartRequestMessage(int questId) {
        this.questId = questId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(questId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        questId = buf.readUShort();
        if (questId < 0 || questId > 65535)
            throw new RuntimeException("Forbidden value on questId = " + questId + ", it doesn't respect the following condition : questId < 0 || questId > 65535");
    }
    
}
