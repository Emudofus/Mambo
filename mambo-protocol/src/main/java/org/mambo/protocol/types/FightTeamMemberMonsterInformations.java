

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FightTeamMemberMonsterInformations extends FightTeamMemberInformations {
    public static final short TYPE_ID = 6;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int monsterId;
    public byte grade;
    
    public FightTeamMemberMonsterInformations() { }
    
    public FightTeamMemberMonsterInformations(int id, int monsterId, byte grade) {
        super(id);
        this.monsterId = monsterId;
        this.grade = grade;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(monsterId);
        buf.writeByte(grade);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        monsterId = buf.readInt();
        grade = buf.readByte();
        if (grade < 0)
            throw new RuntimeException("Forbidden value on grade = " + grade + ", it doesn't respect the following condition : grade < 0");
    }
    
}
