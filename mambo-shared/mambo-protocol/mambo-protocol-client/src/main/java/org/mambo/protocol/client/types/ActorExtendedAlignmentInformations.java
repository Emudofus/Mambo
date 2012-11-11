

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ActorExtendedAlignmentInformations extends ActorAlignmentInformations {
    public static final short TYPE_ID = 202;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int honor;
    public int honorGradeFloor;
    public int honorNextGradeFloor;
    public boolean pvpEnabled;
    
    public ActorExtendedAlignmentInformations() { }
    
    public ActorExtendedAlignmentInformations(byte alignmentSide, byte alignmentValue, byte alignmentGrade, int dishonor, int characterPower, int honor, int honorGradeFloor, int honorNextGradeFloor, boolean pvpEnabled) {
        super(alignmentSide, alignmentValue, alignmentGrade, dishonor, characterPower);
        this.honor = honor;
        this.honorGradeFloor = honorGradeFloor;
        this.honorNextGradeFloor = honorNextGradeFloor;
        this.pvpEnabled = pvpEnabled;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedShort(honor);
        writer.writeUnsignedShort(honorGradeFloor);
        writer.writeUnsignedShort(honorNextGradeFloor);
        writer.writeBoolean(pvpEnabled);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        honor = reader.readUnsignedShort();
        if (honor < 0 || honor > 20000)
            throw new RuntimeException("Forbidden value on honor = " + honor + ", it doesn't respect the following condition : honor < 0 || honor > 20000");
        honorGradeFloor = reader.readUnsignedShort();
        if (honorGradeFloor < 0 || honorGradeFloor > 20000)
            throw new RuntimeException("Forbidden value on honorGradeFloor = " + honorGradeFloor + ", it doesn't respect the following condition : honorGradeFloor < 0 || honorGradeFloor > 20000");
        honorNextGradeFloor = reader.readUnsignedShort();
        if (honorNextGradeFloor < 0 || honorNextGradeFloor > 20000)
            throw new RuntimeException("Forbidden value on honorNextGradeFloor = " + honorNextGradeFloor + ", it doesn't respect the following condition : honorNextGradeFloor < 0 || honorNextGradeFloor > 20000");
        pvpEnabled = reader.readBoolean();
    }
    
}
