

// Generated on 11/11/2012 19:06:13
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class MonsterInGroupInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 144;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int creatureGenericId;
    public byte grade;
    public EntityLook look;
    
    public MonsterInGroupInformations() { }
    
    public MonsterInGroupInformations(int creatureGenericId, byte grade, EntityLook look) {
        this.creatureGenericId = creatureGenericId;
        this.grade = grade;
        this.look = look;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(creatureGenericId);
        writer.writeByte(grade);
        look.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        creatureGenericId = reader.readInt();
        grade = reader.readByte();
        if (grade < 0)
            throw new RuntimeException("Forbidden value on grade = " + grade + ", it doesn't respect the following condition : grade < 0");
        look = new EntityLook();
        look.deserialize(reader);
    }
    
}
