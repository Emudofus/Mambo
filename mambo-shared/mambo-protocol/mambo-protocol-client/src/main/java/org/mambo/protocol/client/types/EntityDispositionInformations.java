

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class EntityDispositionInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 60;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short cellId;
    public byte direction;
    
    public EntityDispositionInformations() { }
    
    public EntityDispositionInformations(short cellId, byte direction) {
        this.cellId = cellId;
        this.direction = direction;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(cellId);
        writer.writeByte(direction);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        cellId = reader.readShort();
        if (cellId < -1 || cellId > 559)
            throw new RuntimeException("Forbidden value on cellId = " + cellId + ", it doesn't respect the following condition : cellId < -1 || cellId > 559");
        direction = reader.readByte();
        if (direction < 0)
            throw new RuntimeException("Forbidden value on direction = " + direction + ", it doesn't respect the following condition : direction < 0");
    }
    
}
