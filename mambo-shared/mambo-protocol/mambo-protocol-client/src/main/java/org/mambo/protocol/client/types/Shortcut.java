

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class Shortcut implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 369;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int slot;
    
    public Shortcut() { }
    
    public Shortcut(int slot) {
        this.slot = slot;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(slot);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        slot = reader.readInt();
        if (slot < 0 || slot > 99)
            throw new RuntimeException("Forbidden value on slot = " + slot + ", it doesn't respect the following condition : slot < 0 || slot > 99");
    }
    
}
