

// Generated on 12/14/2012 18:44:16
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeStartOkNpcTradeMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5785;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int npcId;
    
    public ExchangeStartOkNpcTradeMessage() { }
    
    public ExchangeStartOkNpcTradeMessage(int npcId) {
        this.npcId = npcId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(npcId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        npcId = reader.readInt();
    }
    
}
