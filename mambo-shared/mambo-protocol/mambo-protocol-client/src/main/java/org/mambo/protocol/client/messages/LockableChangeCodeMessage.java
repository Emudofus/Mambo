

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class LockableChangeCodeMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5666;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String code;
    
    public LockableChangeCodeMessage() { }
    
    public LockableChangeCodeMessage(String code) {
        this.code = code;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(code);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        code = reader.readString();
    }
    
}
