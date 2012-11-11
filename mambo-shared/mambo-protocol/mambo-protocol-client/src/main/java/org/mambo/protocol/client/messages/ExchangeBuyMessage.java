

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeBuyMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5774;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objectToBuyId;
    public int quantity;
    
    public ExchangeBuyMessage() { }
    
    public ExchangeBuyMessage(int objectToBuyId, int quantity) {
        this.objectToBuyId = objectToBuyId;
        this.quantity = quantity;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(objectToBuyId);
        writer.writeInt(quantity);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        objectToBuyId = reader.readInt();
        if (objectToBuyId < 0)
            throw new RuntimeException("Forbidden value on objectToBuyId = " + objectToBuyId + ", it doesn't respect the following condition : objectToBuyId < 0");
        quantity = reader.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
    }
    
}
