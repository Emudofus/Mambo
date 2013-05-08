

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AlignmentBonusInformations extends NetworkType {
    public static final short TYPE_ID = 135;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeInt(pctbonus);
        buf.writeDouble(grademult);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        pctbonus = buf.readInt();
        if (pctbonus < 0)
            throw new RuntimeException("Forbidden value on pctbonus = " + pctbonus + ", it doesn't respect the following condition : pctbonus < 0");
        grademult = buf.readDouble();
    }
    
}
