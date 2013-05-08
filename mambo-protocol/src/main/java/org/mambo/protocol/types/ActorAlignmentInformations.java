

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ActorAlignmentInformations extends NetworkType {
    public static final short TYPE_ID = 201;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte alignmentSide;
    public byte alignmentValue;
    public byte alignmentGrade;
    public int dishonor;
    public int characterPower;
    
    public ActorAlignmentInformations() { }
    
    public ActorAlignmentInformations(byte alignmentSide, byte alignmentValue, byte alignmentGrade, int dishonor, int characterPower) {
        this.alignmentSide = alignmentSide;
        this.alignmentValue = alignmentValue;
        this.alignmentGrade = alignmentGrade;
        this.dishonor = dishonor;
        this.characterPower = characterPower;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(alignmentSide);
        buf.writeByte(alignmentValue);
        buf.writeByte(alignmentGrade);
        buf.writeUShort(dishonor);
        buf.writeInt(characterPower);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        alignmentSide = buf.readByte();
        alignmentValue = buf.readByte();
        if (alignmentValue < 0)
            throw new RuntimeException("Forbidden value on alignmentValue = " + alignmentValue + ", it doesn't respect the following condition : alignmentValue < 0");
        alignmentGrade = buf.readByte();
        if (alignmentGrade < 0)
            throw new RuntimeException("Forbidden value on alignmentGrade = " + alignmentGrade + ", it doesn't respect the following condition : alignmentGrade < 0");
        dishonor = buf.readUShort();
        if (dishonor < 0 || dishonor > 500)
            throw new RuntimeException("Forbidden value on dishonor = " + dishonor + ", it doesn't respect the following condition : dishonor < 0 || dishonor > 500");
        characterPower = buf.readInt();
        if (characterPower < 0)
            throw new RuntimeException("Forbidden value on characterPower = " + characterPower + ", it doesn't respect the following condition : characterPower < 0");
    }
    
}
