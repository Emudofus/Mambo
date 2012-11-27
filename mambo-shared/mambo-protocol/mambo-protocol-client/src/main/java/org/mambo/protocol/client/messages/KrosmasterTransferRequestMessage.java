

// Generated on 11/11/2012 20:41:38
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class KrosmasterTransferRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6349;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String uid;
    
    public KrosmasterTransferRequestMessage() { }
    
    public KrosmasterTransferRequestMessage(String uid) {
        this.uid = uid;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(uid);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        uid = reader.readString();
    }
    
}
