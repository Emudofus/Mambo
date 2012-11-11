

// Generated on 11/11/2012 19:17:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
