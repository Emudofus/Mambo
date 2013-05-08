

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(grade);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        grade = buf.readInt();
        if (grade < 0)
            throw new RuntimeException("Forbidden value on grade = " + grade + ", it doesn't respect the following condition : grade < 0");
    }
    
}
