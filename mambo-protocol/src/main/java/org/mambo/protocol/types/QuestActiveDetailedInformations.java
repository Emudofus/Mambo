

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(stepId);
        buf.writeUShort(objectives.length);
        for (QuestObjectiveInformations entry : objectives) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        stepId = buf.readShort();
        if (stepId < 0)
            throw new RuntimeException("Forbidden value on stepId = " + stepId + ", it doesn't respect the following condition : stepId < 0");
        int limit = buf.readUShort();
        objectives = new QuestObjectiveInformations[limit];
        for (int i = 0; i < limit; i++) {
            objectives[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            objectives[i].deserialize(buf);
        }
    }
    
}
