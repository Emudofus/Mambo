

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(quantity);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        quantity = buf.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
    }
    
}
