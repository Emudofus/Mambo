

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeCraftResultWithObjectIdMessage extends ExchangeCraftResultMessage {
    public static final int MESSAGE_ID = 6000;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objectGenericId;
    
    public ExchangeCraftResultWithObjectIdMessage() { }
    
    public ExchangeCraftResultWithObjectIdMessage(byte craftResult, int objectGenericId) {
        super(craftResult);
        this.objectGenericId = objectGenericId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(objectGenericId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        objectGenericId = buf.readInt();
        if (objectGenericId < 0)
            throw new RuntimeException("Forbidden value on objectGenericId = " + objectGenericId + ", it doesn't respect the following condition : objectGenericId < 0");
    }
    
}
