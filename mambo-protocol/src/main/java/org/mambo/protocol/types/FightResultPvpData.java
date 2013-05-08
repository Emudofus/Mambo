

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FightResultPvpData extends FightResultAdditionalData {
    public static final short TYPE_ID = 190;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short grade;
    public int minHonorForGrade;
    public int maxHonorForGrade;
    public int honor;
    public short honorDelta;
    public int dishonor;
    public short dishonorDelta;
    
    public FightResultPvpData() { }
    
    public FightResultPvpData(short grade, int minHonorForGrade, int maxHonorForGrade, int honor, short honorDelta, int dishonor, short dishonorDelta) {
        this.grade = grade;
        this.minHonorForGrade = minHonorForGrade;
        this.maxHonorForGrade = maxHonorForGrade;
        this.honor = honor;
        this.honorDelta = honorDelta;
        this.dishonor = dishonor;
        this.dishonorDelta = dishonorDelta;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUByte(grade);
        buf.writeUShort(minHonorForGrade);
        buf.writeUShort(maxHonorForGrade);
        buf.writeUShort(honor);
        buf.writeShort(honorDelta);
        buf.writeUShort(dishonor);
        buf.writeShort(dishonorDelta);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        grade = buf.readUByte();
        if (grade < 0 || grade > 255)
            throw new RuntimeException("Forbidden value on grade = " + grade + ", it doesn't respect the following condition : grade < 0 || grade > 255");
        minHonorForGrade = buf.readUShort();
        if (minHonorForGrade < 0 || minHonorForGrade > 20000)
            throw new RuntimeException("Forbidden value on minHonorForGrade = " + minHonorForGrade + ", it doesn't respect the following condition : minHonorForGrade < 0 || minHonorForGrade > 20000");
        maxHonorForGrade = buf.readUShort();
        if (maxHonorForGrade < 0 || maxHonorForGrade > 20000)
            throw new RuntimeException("Forbidden value on maxHonorForGrade = " + maxHonorForGrade + ", it doesn't respect the following condition : maxHonorForGrade < 0 || maxHonorForGrade > 20000");
        honor = buf.readUShort();
        if (honor < 0 || honor > 20000)
            throw new RuntimeException("Forbidden value on honor = " + honor + ", it doesn't respect the following condition : honor < 0 || honor > 20000");
        honorDelta = buf.readShort();
        dishonor = buf.readUShort();
        if (dishonor < 0 || dishonor > 500)
            throw new RuntimeException("Forbidden value on dishonor = " + dishonor + ", it doesn't respect the following condition : dishonor < 0 || dishonor > 500");
        dishonorDelta = buf.readShort();
    }
    
}
