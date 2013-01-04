

// Generated on 01/04/2013 14:54:44
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ActorOrientation implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 353;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int id;
    public byte direction;
    
    public ActorOrientation() { }
    
    public ActorOrientation(int id, byte direction) {
        this.id = id;
        this.direction = direction;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(id);
        writer.writeByte(direction);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readInt();
        direction = reader.readByte();
        if (direction < 0)
            throw new RuntimeException("Forbidden value on direction = " + direction + ", it doesn't respect the following condition : direction < 0");
    }
    
}
