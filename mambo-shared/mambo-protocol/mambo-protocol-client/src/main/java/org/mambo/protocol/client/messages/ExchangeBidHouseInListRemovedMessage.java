

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeBidHouseInListRemovedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5950;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int itemUID;
    
    public ExchangeBidHouseInListRemovedMessage() { }
    
    public ExchangeBidHouseInListRemovedMessage(int itemUID) {
        this.itemUID = itemUID;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(itemUID);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        itemUID = reader.readInt();
    }
    
}
