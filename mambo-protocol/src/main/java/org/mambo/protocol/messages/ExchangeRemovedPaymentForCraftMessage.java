

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeBoolean(onlySuccess);
        buf.writeInt(objectUID);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        onlySuccess = buf.readBoolean();
        objectUID = buf.readInt();
        if (objectUID < 0)
            throw new RuntimeException("Forbidden value on objectUID = " + objectUID + ", it doesn't respect the following condition : objectUID < 0");
    }
    
}
