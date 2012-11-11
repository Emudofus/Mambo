

// Generated on 11/11/2012 19:17:09
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeItemPaymentForCraftMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5831;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean onlySuccess;
    public ObjectItemNotInContainer object;
    
    public ExchangeItemPaymentForCraftMessage() { }
    
    public ExchangeItemPaymentForCraftMessage(boolean onlySuccess, ObjectItemNotInContainer object) {
        this.onlySuccess = onlySuccess;
        this.object = object;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(onlySuccess);
        object.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        onlySuccess = reader.readBoolean();
        object = new ObjectItemNotInContainer();
        object.deserialize(reader);
    }
    
}
