

// Generated on 01/04/2013 14:54:23
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class DisplayNumericalValueMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5808;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int entityId;
    public int value;
    public byte type;
    
    public DisplayNumericalValueMessage() { }
    
    public DisplayNumericalValueMessage(int entityId, int value, byte type) {
        this.entityId = entityId;
        this.value = value;
        this.type = type;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(entityId);
        writer.writeInt(value);
        writer.writeByte(type);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        entityId = reader.readInt();
        value = reader.readInt();
        type = reader.readByte();
        if (type < 0)
            throw new RuntimeException("Forbidden value on type = " + type + ", it doesn't respect the following condition : type < 0");
    }
    
}
