

// Generated on 12/14/2012 18:44:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeBidHouseGenericItemAddedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5947;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objGenericId;
    
    public ExchangeBidHouseGenericItemAddedMessage() { }
    
    public ExchangeBidHouseGenericItemAddedMessage(int objGenericId) {
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
