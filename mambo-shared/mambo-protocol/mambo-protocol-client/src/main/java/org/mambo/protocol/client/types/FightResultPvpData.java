

// Generated on 12/14/2012 18:44:21
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedByte(grade);
        writer.writeUnsignedShort(minHonorForGrade);
        writer.writeUnsignedShort(maxHonorForGrade);
        writer.writeUnsignedShort(honor);
        writer.writeShort(honorDelta);
        writer.writeUnsignedShort(dishonor);
        writer.writeShort(dishonorDelta);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        grade = reader.readUnsignedByte();
        if (grade < 0 || grade > 255)
            throw new RuntimeException("Forbidden value on grade = " + grade + ", it doesn't respect the following condition : grade < 0 || grade > 255");
        minHonorForGrade = reader.readUnsignedShort();
        if (minHonorForGrade < 0 || minHonorForGrade > 20000)
            throw new RuntimeException("Forbidden value on minHonorForGrade = " + minHonorForGrade + ", it doesn't respect the following condition : minHonorForGrade < 0 || minHonorForGrade > 20000");
        maxHonorForGrade = reader.readUnsignedShort();
        if (maxHonorForGrade < 0 || maxHonorForGrade > 20000)
            throw new RuntimeException("Forbidden value on maxHonorForGrade = " + maxHonorForGrade + ", it doesn't respect the following condition : maxHonorForGrade < 0 || maxHonorForGrade > 20000");
        honor = reader.readUnsignedShort();
        if (honor < 0 || honor > 20000)
            throw new RuntimeException("Forbidden value on honor = " + honor + ", it doesn't respect the following condition : honor < 0 || honor > 20000");
        honorDelta = reader.readShort();
        dishonor = reader.readUnsignedShort();
        if (dishonor < 0 || dishonor > 500)
            throw new RuntimeException("Forbidden value on dishonor = " + dishonor + ", it doesn't respect the following condition : dishonor < 0 || dishonor > 500");
        dishonorDelta = reader.readShort();
    }
    
}
