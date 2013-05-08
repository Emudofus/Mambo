

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AdditionalTaxCollectorInformations extends NetworkType {
    public static final short TYPE_ID = 165;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public String collectorCallerName;
    public int date;
    
    public AdditionalTaxCollectorInformations() { }
    
    public AdditionalTaxCollectorInformations(String collectorCallerName, int date) {
        this.collectorCallerName = collectorCallerName;
        this.date = date;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(collectorCallerName);
        buf.writeInt(date);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        collectorCallerName = buf.readString();
        date = buf.readInt();
        if (date < 0)
            throw new RuntimeException("Forbidden value on date = " + date + ", it doesn't respect the following condition : date < 0");
    }
    
}
