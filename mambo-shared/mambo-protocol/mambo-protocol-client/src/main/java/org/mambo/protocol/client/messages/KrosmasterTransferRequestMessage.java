

// Generated on 01/04/2013 14:54:43
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
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
