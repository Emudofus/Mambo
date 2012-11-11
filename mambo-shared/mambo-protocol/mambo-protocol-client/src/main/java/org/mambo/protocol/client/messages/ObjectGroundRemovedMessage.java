

// Generated on 11/11/2012 19:17:04
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ObjectGroundRemovedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 3014;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short cell;
    
    public ObjectGroundRemovedMessage() { }
    
    public ObjectGroundRemovedMessage(short cell) {
        this.cell = cell;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(cell);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        cell = reader.readShort();
        if (cell < 0 || cell > 559)
            throw new RuntimeException("Forbidden value on cell = " + cell + ", it doesn't respect the following condition : cell < 0 || cell > 559");
    }
    
}
