

// Generated on 11/11/2012 19:06:13
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class QuestObjectiveInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 385;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short objectiveId;
    public boolean objectiveStatus;
    
    public QuestObjectiveInformations() { }
    
    public QuestObjectiveInformations(short objectiveId, boolean objectiveStatus) {
        this.objectiveId = objectiveId;
        this.objectiveStatus = objectiveStatus;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(objectiveId);
        writer.writeBoolean(objectiveStatus);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        objectiveId = reader.readShort();
        if (objectiveId < 0)
            throw new RuntimeException("Forbidden value on objectiveId = " + objectiveId + ", it doesn't respect the following condition : objectiveId < 0");
        objectiveStatus = reader.readBoolean();
    }
    
}
