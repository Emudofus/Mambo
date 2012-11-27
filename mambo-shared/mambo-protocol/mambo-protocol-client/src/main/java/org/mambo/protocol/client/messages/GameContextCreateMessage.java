

// Generated on 11/11/2012 20:41:25
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameContextCreateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 200;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte context;
    
    public GameContextCreateMessage() { }
    
    public GameContextCreateMessage(byte context) {
        this.context = context;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(context);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        context = reader.readByte();
        if (context < 0)
            throw new RuntimeException("Forbidden value on context = " + context + ", it doesn't respect the following condition : context < 0");
    }
    
}
