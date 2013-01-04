

// Generated on 01/04/2013 14:54:36
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeObjectMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5515;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean remote;
    
    public ExchangeObjectMessage() { }
    
    public ExchangeObjectMessage(boolean remote) {
        this.remote = remote;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(remote);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        remote = reader.readBoolean();
    }
    
}
