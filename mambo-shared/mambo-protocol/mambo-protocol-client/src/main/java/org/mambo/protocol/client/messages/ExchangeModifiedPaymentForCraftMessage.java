

// Generated on 01/04/2013 14:54:35
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeModifiedPaymentForCraftMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5832;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean onlySuccess;
    public ObjectItemNotInContainer object;
    
    public ExchangeModifiedPaymentForCraftMessage() { }
    
    public ExchangeModifiedPaymentForCraftMessage(boolean onlySuccess, ObjectItemNotInContainer object) {
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
