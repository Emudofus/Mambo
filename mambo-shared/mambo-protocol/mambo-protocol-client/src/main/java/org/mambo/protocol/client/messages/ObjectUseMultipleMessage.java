

// Generated on 11/11/2012 19:17:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ObjectUseMultipleMessage extends ObjectUseMessage {
    public static final int MESSAGE_ID = 6234;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int quantity;
    
    public ObjectUseMultipleMessage() { }
    
    public ObjectUseMultipleMessage(int objectUID, int quantity) {
        super(objectUID);
        this.quantity = quantity;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(quantity);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        quantity = reader.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
    }
    
}
