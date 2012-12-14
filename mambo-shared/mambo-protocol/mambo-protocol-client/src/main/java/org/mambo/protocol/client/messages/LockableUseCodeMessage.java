

// Generated on 12/14/2012 18:44:08
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class LockableUseCodeMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5667;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String code;
    
    public LockableUseCodeMessage() { }
    
    public LockableUseCodeMessage(String code) {
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
