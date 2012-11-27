

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class MonsterInGroupLightInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 395;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int creatureGenericId;
    public byte grade;
    
    public MonsterInGroupLightInformations() { }
    
    public MonsterInGroupLightInformations(int creatureGenericId, byte grade) {
        this.creatureGenericId = creatureGenericId;
        this.grade = grade;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(creatureGenericId);
        writer.writeByte(grade);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        creatureGenericId = reader.readInt();
        grade = reader.readByte();
        if (grade < 0)
            throw new RuntimeException("Forbidden value on grade = " + grade + ", it doesn't respect the following condition : grade < 0");
    }
    
}
