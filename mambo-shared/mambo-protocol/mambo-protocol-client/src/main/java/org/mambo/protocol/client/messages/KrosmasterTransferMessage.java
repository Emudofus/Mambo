

// Generated on 11/11/2012 20:41:38
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class KrosmasterTransferMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6348;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String uid;
    public byte failure;
    
    public KrosmasterTransferMessage() { }
    
    public KrosmasterTransferMessage(String uid, byte failure) {
        this.uid = uid;
        this.failure = failure;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(uid);
        writer.writeByte(failure);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        uid = reader.readString();
        failure = reader.readByte();
        if (failure < 0)
            throw new RuntimeException("Forbidden value on failure = " + failure + ", it doesn't respect the following condition : failure < 0");
    }
    
}
