

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ContentPart implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 350;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public String id;
    public byte state;
    
    public ContentPart() { }
    
    public ContentPart(String id, byte state) {
        this.id = id;
        this.state = state;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(id);
        writer.writeByte(state);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readString();
        state = reader.readByte();
        if (state < 0)
            throw new RuntimeException("Forbidden value on state = " + state + ", it doesn't respect the following condition : state < 0");
    }
    
}
