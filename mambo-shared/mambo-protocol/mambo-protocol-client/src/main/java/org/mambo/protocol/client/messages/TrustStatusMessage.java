

// Generated on 12/14/2012 18:44:18
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class TrustStatusMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6267;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean trusted;
    
    public TrustStatusMessage() { }
    
    public TrustStatusMessage(boolean trusted) {
        this.trusted = trusted;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(trusted);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        trusted = reader.readBoolean();
    }
    
}
