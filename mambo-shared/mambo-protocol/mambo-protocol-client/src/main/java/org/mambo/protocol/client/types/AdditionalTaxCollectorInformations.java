

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class AdditionalTaxCollectorInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 165;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeString(collectorCallerName);
        writer.writeInt(date);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        collectorCallerName = reader.readString();
        date = reader.readInt();
        if (date < 0)
            throw new RuntimeException("Forbidden value on date = " + date + ", it doesn't respect the following condition : date < 0");
    }
    
}
