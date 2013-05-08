

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayNpcQuestFlag extends NetworkType {
    public static final short TYPE_ID = 384;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short[] questsToValidId;
    public short[] questsToStartId;
    
    public GameRolePlayNpcQuestFlag() { }
    
    public GameRolePlayNpcQuestFlag(short[] questsToValidId, short[] questsToStartId) {
        this.questsToValidId = questsToValidId;
        this.questsToStartId = questsToStartId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(questsToValidId.length);
        for (short entry : questsToValidId) {
            buf.writeShort(entry);
        }
        buf.writeUShort(questsToStartId.length);
        for (short entry : questsToStartId) {
            buf.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        questsToValidId = new short[limit];
        for (int i = 0; i < limit; i++) {
            questsToValidId[i] = buf.readShort();
        }
        limit = buf.readUShort();
        questsToStartId = new short[limit];
        for (int i = 0; i < limit; i++) {
            questsToStartId[i] = buf.readShort();
        }
    }
    
}
