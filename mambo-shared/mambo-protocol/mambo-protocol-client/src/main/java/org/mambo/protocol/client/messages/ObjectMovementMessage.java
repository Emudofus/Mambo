

// Generated on 11/11/2012 19:17:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ObjectMovementMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 3010;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objectUID;
    public short position;
    
    public ObjectMovementMessage() { }
    
    public ObjectMovementMessage(int objectUID, short position) {
        this.objectUID = objectUID;
        this.position = position;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(objectUID);
        writer.writeUnsignedByte(position);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        objectUID = reader.readInt();
        if (objectUID < 0)
            throw new RuntimeException("Forbidden value on objectUID = " + objectUID + ", it doesn't respect the following condition : objectUID < 0");
        position = reader.readUnsignedByte();
        if (position < 0 || position > 255)
            throw new RuntimeException("Forbidden value on position = " + position + ", it doesn't respect the following condition : position < 0 || position > 255");
    }
    
}
