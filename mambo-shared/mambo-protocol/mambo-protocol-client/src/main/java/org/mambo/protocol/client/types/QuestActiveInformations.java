

// Generated on 11/11/2012 19:06:13
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class QuestActiveInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 381;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short questId;
    
    public QuestActiveInformations() { }
    
    public QuestActiveInformations(short questId) {
        this.questId = questId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(questId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        questId = reader.readShort();
        if (questId < 0)
            throw new RuntimeException("Forbidden value on questId = " + questId + ", it doesn't respect the following condition : questId < 0");
    }
    
}
