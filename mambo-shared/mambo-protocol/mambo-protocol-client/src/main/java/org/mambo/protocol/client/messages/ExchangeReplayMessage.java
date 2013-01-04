

// Generated on 01/04/2013 14:54:36
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeReplayMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6002;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int count;
    
    public ExchangeReplayMessage() { }
    
    public ExchangeReplayMessage(int count) {
        this.count = count;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(count);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        count = reader.readInt();
    }
    
}
