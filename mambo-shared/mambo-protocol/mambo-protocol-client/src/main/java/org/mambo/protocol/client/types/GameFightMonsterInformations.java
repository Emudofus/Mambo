

// Generated on 11/11/2012 19:06:12
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(creatureGenericId);
        writer.writeByte(creatureGrade);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        creatureGenericId = reader.readShort();
        if (creatureGenericId < 0)
            throw new RuntimeException("Forbidden value on creatureGenericId = " + creatureGenericId + ", it doesn't respect the following condition : creatureGenericId < 0");
        creatureGrade = reader.readByte();
        if (creatureGrade < 0)
            throw new RuntimeException("Forbidden value on creatureGrade = " + creatureGrade + ", it doesn't respect the following condition : creatureGrade < 0");
    }
    
}
