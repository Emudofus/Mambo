

// Generated on 01/04/2013 14:54:45
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(monsterId);
        writer.writeByte(grade);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        monsterId = reader.readInt();
        grade = reader.readByte();
        if (grade < 0)
            throw new RuntimeException("Forbidden value on grade = " + grade + ", it doesn't respect the following condition : grade < 0");
    }
    
}
