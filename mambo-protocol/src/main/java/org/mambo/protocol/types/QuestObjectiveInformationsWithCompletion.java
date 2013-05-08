

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class QuestObjectiveInformationsWithCompletion extends QuestObjectiveInformations {
    public static final short TYPE_ID = 386;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short curCompletion;
    public short maxCompletion;
    
    public QuestObjectiveInformationsWithCompletion() { }
    
    public QuestObjectiveInformationsWithCompletion(short objectiveId, boolean objectiveStatus, String[] dialogParams, short curCompletion, short maxCompletion) {
        super(objectiveId, objectiveStatus, dialogParams);
        this.curCompletion = curCompletion;
        this.maxCompletion = maxCompletion;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(curCompletion);
        buf.writeShort(maxCompletion);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        curCompletion = buf.readShort();
        if (curCompletion < 0)
            throw new RuntimeException("Forbidden value on curCompletion = " + curCompletion + ", it doesn't respect the following condition : curCompletion < 0");
        maxCompletion = buf.readShort();
        if (maxCompletion < 0)
            throw new RuntimeException("Forbidden value on maxCompletion = " + maxCompletion + ", it doesn't respect the following condition : maxCompletion < 0");
    }
    
}
