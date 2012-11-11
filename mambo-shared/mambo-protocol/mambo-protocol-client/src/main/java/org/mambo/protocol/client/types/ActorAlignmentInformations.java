

// Generated on 11/11/2012 19:06:11
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ActorAlignmentInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 201;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(alignmentSide);
        writer.writeByte(alignmentValue);
        writer.writeByte(alignmentGrade);
        writer.writeUnsignedShort(dishonor);
        writer.writeInt(characterPower);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        alignmentSide = reader.readByte();
        alignmentValue = reader.readByte();
        if (alignmentValue < 0)
            throw new RuntimeException("Forbidden value on alignmentValue = " + alignmentValue + ", it doesn't respect the following condition : alignmentValue < 0");
        alignmentGrade = reader.readByte();
        if (alignmentGrade < 0)
            throw new RuntimeException("Forbidden value on alignmentGrade = " + alignmentGrade + ", it doesn't respect the following condition : alignmentGrade < 0");
        dishonor = reader.readUnsignedShort();
        if (dishonor < 0 || dishonor > 500)
            throw new RuntimeException("Forbidden value on dishonor = " + dishonor + ", it doesn't respect the following condition : dishonor < 0 || dishonor > 500");
        characterPower = reader.readInt();
        if (characterPower < 0)
            throw new RuntimeException("Forbidden value on characterPower = " + characterPower + ", it doesn't respect the following condition : characterPower < 0");
    }
    
}
