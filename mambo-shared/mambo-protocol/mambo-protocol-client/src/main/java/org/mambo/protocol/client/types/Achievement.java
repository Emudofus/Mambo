

// Generated on 11/11/2012 19:06:11
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class Achievement implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 363;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short id;
    
    public Achievement() { }
    
    public Achievement(short id) {
        this.id = id;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(id);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readShort();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
    }
    
}
