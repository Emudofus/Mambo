

// Generated on 11/11/2012 20:41:27
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class EmotePlayErrorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5688;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte emoteId;
    
    public EmotePlayErrorMessage() { }
    
    public EmotePlayErrorMessage(byte emoteId) {
        this.emoteId = emoteId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(emoteId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        emoteId = reader.readByte();
    }
    
}
