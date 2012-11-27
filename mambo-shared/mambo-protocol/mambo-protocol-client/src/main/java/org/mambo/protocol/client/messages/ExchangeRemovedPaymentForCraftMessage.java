

// Generated on 11/11/2012 20:41:35
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeRemovedPaymentForCraftMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6031;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean onlySuccess;
    public int objectUID;
    
    public ExchangeRemovedPaymentForCraftMessage() { }
    
    public ExchangeRemovedPaymentForCraftMessage(boolean onlySuccess, int objectUID) {
        this.onlySuccess = onlySuccess;
        this.objectUID = objectUID;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(onlySuccess);
        writer.writeInt(objectUID);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        onlySuccess = reader.readBoolean();
        objectUID = reader.readInt();
        if (objectUID < 0)
            throw new RuntimeException("Forbidden value on objectUID = " + objectUID + ", it doesn't respect the following condition : objectUID < 0");
    }
    
}
