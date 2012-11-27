

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeBidHouseBuyResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6272;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int uid;
    public boolean bought;
    
    public ExchangeBidHouseBuyResultMessage() { }
    
    public ExchangeBidHouseBuyResultMessage(int uid, boolean bought) {
        this.uid = uid;
        this.bought = bought;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(uid);
        writer.writeBoolean(bought);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        uid = reader.readInt();
        if (uid < 0)
            throw new RuntimeException("Forbidden value on uid = " + uid + ", it doesn't respect the following condition : uid < 0");
        bought = reader.readBoolean();
    }
    
}
