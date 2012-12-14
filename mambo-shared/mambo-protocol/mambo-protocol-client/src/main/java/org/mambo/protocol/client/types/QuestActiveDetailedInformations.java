

// Generated on 12/14/2012 18:44:22
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class QuestActiveDetailedInformations extends QuestActiveInformations {
    public static final short TYPE_ID = 382;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short stepId;
    public QuestObjectiveInformations[] objectives;
    
    public QuestActiveDetailedInformations() { }
    
    public QuestActiveDetailedInformations(short questId, short stepId, QuestObjectiveInformations[] objectives) {
        super(questId);
        this.stepId = stepId;
        this.objectives = objectives;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(stepId);
        writer.writeUnsignedShort(objectives.length);
        for (QuestObjectiveInformations entry : objectives) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        stepId = reader.readShort();
        if (stepId < 0)
            throw new RuntimeException("Forbidden value on stepId = " + stepId + ", it doesn't respect the following condition : stepId < 0");
        int limit = reader.readUnsignedShort();
        objectives = new QuestObjectiveInformations[limit];
        for (int i = 0; i < limit; i++) {
            objectives[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), QuestObjectiveInformations.class);
            objectives[i].deserialize(reader);
        }
    }
    
}
