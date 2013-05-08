

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeBoolean(onlySuccess);
        object.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        onlySuccess = buf.readBoolean();
        object = new ObjectItemNotInContainer();
        object.deserialize(buf);
    }
    
}
