

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class EntityMovementInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 63;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int id;
    public byte[] steps;
    
    public EntityMovementInformations() { }
    
    public EntityMovementInformations(int id, byte[] steps) {
        this.id = id;
        this.steps = steps;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(id);
        writer.writeUnsignedShort(steps.length);
        for (byte entry : steps) {
            writer.writeByte(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readInt();
        int limit = reader.readUnsignedShort();
        steps = new byte[limit];
        for (int i = 0; i < limit; i++) {
            steps[i] = reader.readByte();
        }
    }
    
}
