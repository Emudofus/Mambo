

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightMonsterInformations extends GameFightAIInformations {
    public static final short TYPE_ID = 29;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short creatureGenericId;
    public byte creatureGrade;
    
    public GameFightMonsterInformations() { }
    
    public GameFightMonsterInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, boolean alive, GameFightMinimalStats stats, short creatureGenericId, byte creatureGrade) {
        super(contextualId, look, disposition, teamId, alive, stats);
        this.creatureGenericId = creatureGenericId;
        this.creatureGrade = creatureGrade;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(creatureGenericId);
        buf.writeByte(creatureGrade);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        creatureGenericId = buf.readShort();
        if (creatureGenericId < 0)
            throw new RuntimeException("Forbidden value on creatureGenericId = " + creatureGenericId + ", it doesn't respect the following condition : creatureGenericId < 0");
        creatureGrade = buf.readByte();
        if (creatureGrade < 0)
            throw new RuntimeException("Forbidden value on creatureGrade = " + creatureGrade + ", it doesn't respect the following condition : creatureGrade < 0");
    }
    
}
