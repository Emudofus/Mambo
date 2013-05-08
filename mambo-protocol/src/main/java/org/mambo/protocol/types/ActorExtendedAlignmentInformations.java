

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUShort(honor);
        buf.writeUShort(honorGradeFloor);
        buf.writeUShort(honorNextGradeFloor);
        buf.writeBoolean(pvpEnabled);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        honor = buf.readUShort();
        if (honor < 0 || honor > 20000)
            throw new RuntimeException("Forbidden value on honor = " + honor + ", it doesn't respect the following condition : honor < 0 || honor > 20000");
        honorGradeFloor = buf.readUShort();
        if (honorGradeFloor < 0 || honorGradeFloor > 20000)
            throw new RuntimeException("Forbidden value on honorGradeFloor = " + honorGradeFloor + ", it doesn't respect the following condition : honorGradeFloor < 0 || honorGradeFloor > 20000");
        honorNextGradeFloor = buf.readUShort();
        if (honorNextGradeFloor < 0 || honorNextGradeFloor > 20000)
            throw new RuntimeException("Forbidden value on honorNextGradeFloor = " + honorNextGradeFloor + ", it doesn't respect the following condition : honorNextGradeFloor < 0 || honorNextGradeFloor > 20000");
        pvpEnabled = buf.readBoolean();
    }
    
}
