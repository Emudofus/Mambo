

// Generated on 11/11/2012 19:06:13
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class QuestObjectiveInformationsWithCompletion extends QuestObjectiveInformations {
    public static final short TYPE_ID = 386;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short curCompletion;
    public short maxCompletion;
    
    public QuestObjectiveInformationsWithCompletion() { }
    
    public QuestObjectiveInformationsWithCompletion(short objectiveId, boolean objectiveStatus, short curCompletion, short maxCompletion) {
        super(objectiveId, objectiveStatus);
        this.curCompletion = curCompletion;
        this.maxCompletion = maxCompletion;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(curCompletion);
        writer.writeShort(maxCompletion);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        curCompletion = reader.readShort();
        if (curCompletion < 0)
            throw new RuntimeException("Forbidden value on curCompletion = " + curCompletion + ", it doesn't respect the following condition : curCompletion < 0");
        maxCompletion = reader.readShort();
        if (maxCompletion < 0)
            throw new RuntimeException("Forbidden value on maxCompletion = " + maxCompletion + ", it doesn't respect the following condition : maxCompletion < 0");
    }
    
}
