

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MonsterInGroupLightInformations extends NetworkType {
    public static final short TYPE_ID = 395;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeInt(creatureGenericId);
        buf.writeByte(grade);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        creatureGenericId = buf.readInt();
        grade = buf.readByte();
        if (grade < 0)
            throw new RuntimeException("Forbidden value on grade = " + grade + ", it doesn't respect the following condition : grade < 0");
    }
    
}
