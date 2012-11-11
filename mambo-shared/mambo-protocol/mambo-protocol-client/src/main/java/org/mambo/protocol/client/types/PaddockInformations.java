

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PaddockInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 132;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short maxOutdoorMount;
    public short maxItems;
    
    public PaddockInformations() { }
    
    public PaddockInformations(short maxOutdoorMount, short maxItems) {
        this.maxOutdoorMount = maxOutdoorMount;
        this.maxItems = maxItems;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(maxOutdoorMount);
        writer.writeShort(maxItems);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        maxOutdoorMount = reader.readShort();
        if (maxOutdoorMount < 0)
            throw new RuntimeException("Forbidden value on maxOutdoorMount = " + maxOutdoorMount + ", it doesn't respect the following condition : maxOutdoorMount < 0");
        maxItems = reader.readShort();
        if (maxItems < 0)
            throw new RuntimeException("Forbidden value on maxItems = " + maxItems + ", it doesn't respect the following condition : maxItems < 0");
    }
    
}
