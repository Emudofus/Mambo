

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeBidHouseGenericItemRemovedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5948;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objGenericId;
    
    public ExchangeBidHouseGenericItemRemovedMessage() { }
    
    public ExchangeBidHouseGenericItemRemovedMessage(int objGenericId) {
        this.objGenericId = objGenericId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(objGenericId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        objGenericId = reader.readInt();
    }
    
}
