

// Generated on 12/14/2012 18:44:05
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameMapChangeOrientationRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 945;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte direction;
    
    public GameMapChangeOrientationRequestMessage() { }
    
    public GameMapChangeOrientationRequestMessage(byte direction) {
        this.direction = direction;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(direction);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        direction = reader.readByte();
        if (direction < 0)
            throw new RuntimeException("Forbidden value on direction = " + direction + ", it doesn't respect the following condition : direction < 0");
    }
    
}
