

// Generated on 01/04/2013 14:54:31
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class QuestStartedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6091;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int questId;
    
    public QuestStartedMessage() { }
    
    public QuestStartedMessage(int questId) {
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
