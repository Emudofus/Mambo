

// Generated on 11/11/2012 19:17:09
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeReplayCountModifiedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6023;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int count;
    
    public ExchangeReplayCountModifiedMessage() { }
    
    public ExchangeReplayCountModifiedMessage(int count) {
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
