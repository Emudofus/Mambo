

// Generated on 11/11/2012 19:06:14
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class AlignmentBonusInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 135;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int pctbonus;
    public double grademult;
    
    public AlignmentBonusInformations() { }
    
    public AlignmentBonusInformations(int pctbonus, double grademult) {
        this.pctbonus = pctbonus;
        this.grademult = grademult;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(pctbonus);
        writer.writeDouble(grademult);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        pctbonus = reader.readInt();
        if (pctbonus < 0)
            throw new RuntimeException("Forbidden value on pctbonus = " + pctbonus + ", it doesn't respect the following condition : pctbonus < 0");
        grademult = reader.readDouble();
    }
    
}
