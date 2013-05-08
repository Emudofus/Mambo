

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class QuestActiveInformations extends NetworkType {
    public static final short TYPE_ID = 381;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short questId;
    
    public QuestActiveInformations() { }
    
    public QuestActiveInformations(short questId) {
        this.questId = questId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(questId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        questId = buf.readShort();
        if (questId < 0)
            throw new RuntimeException("Forbidden value on questId = " + questId + ", it doesn't respect the following condition : questId < 0");
    }
    
}
