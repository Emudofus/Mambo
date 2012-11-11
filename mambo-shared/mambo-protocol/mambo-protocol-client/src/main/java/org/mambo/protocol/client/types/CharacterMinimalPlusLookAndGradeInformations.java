

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class CharacterMinimalPlusLookAndGradeInformations extends CharacterMinimalPlusLookInformations {
    public static final short TYPE_ID = 193;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int grade;
    
    public CharacterMinimalPlusLookAndGradeInformations() { }
    
    public CharacterMinimalPlusLookAndGradeInformations(int id, short level, String name, EntityLook entityLook, int grade) {
        super(id, level, name, entityLook);
        this.grade = grade;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(grade);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        grade = reader.readInt();
        if (grade < 0)
            throw new RuntimeException("Forbidden value on grade = " + grade + ", it doesn't respect the following condition : grade < 0");
    }
    
}
