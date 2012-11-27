

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class UpdateMountBoost implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 356;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte type;
    
    public UpdateMountBoost() { }
    
    public UpdateMountBoost(byte type) {
        this.type = type;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(type);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        type = reader.readByte();
    }
    
}
