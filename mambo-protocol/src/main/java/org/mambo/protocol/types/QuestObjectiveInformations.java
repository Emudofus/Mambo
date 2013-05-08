

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class QuestObjectiveInformations extends NetworkType {
    public static final short TYPE_ID = 385;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short objectiveId;
    public boolean objectiveStatus;
    public String[] dialogParams;
    
    public QuestObjectiveInformations() { }
    
    public QuestObjectiveInformations(short objectiveId, boolean objectiveStatus, String[] dialogParams) {
        this.objectiveId = objectiveId;
        this.objectiveStatus = objectiveStatus;
        this.dialogParams = dialogParams;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(objectiveId);
        buf.writeBoolean(objectiveStatus);
        buf.writeUShort(dialogParams.length);
        for (String entry : dialogParams) {
            buf.writeString(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        objectiveId = buf.readShort();
        if (objectiveId < 0)
            throw new RuntimeException("Forbidden value on objectiveId = " + objectiveId + ", it doesn't respect the following condition : objectiveId < 0");
        objectiveStatus = buf.readBoolean();
        int limit = buf.readUShort();
        dialogParams = new String[limit];
        for (int i = 0; i < limit; i++) {
            dialogParams[i] = buf.readString();
        }
    }
    
}
