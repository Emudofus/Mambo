

// Generated on 01/04/2013 14:54:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeWaitingResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5786;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean bwait;
    
    public ExchangeWaitingResultMessage() { }
    
    public ExchangeWaitingResultMessage(boolean bwait) {
        this.bwait = bwait;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(bwait);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        bwait = reader.readBoolean();
    }
    
}
