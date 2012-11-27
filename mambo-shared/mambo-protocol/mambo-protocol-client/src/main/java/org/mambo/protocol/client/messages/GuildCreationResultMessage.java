

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GuildCreationResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5554;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte result;
    
    public GuildCreationResultMessage() { }
    
    public GuildCreationResultMessage(byte result) {
        this.result = result;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(result);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        result = reader.readByte();
        if (result < 0)
            throw new RuntimeException("Forbidden value on result = " + result + ", it doesn't respect the following condition : result < 0");
    }
    
}
