

// Generated on 11/11/2012 20:41:38
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class KrosmasterAuthTokenMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6351;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String token;
    
    public KrosmasterAuthTokenMessage() { }
    
    public KrosmasterAuthTokenMessage(String token) {
        this.token = token;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(token);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        token = reader.readString();
    }
    
}
