

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeObjectRemovedFromBagMessage extends ExchangeObjectMessage {
    public static final int MESSAGE_ID = 6010;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objectUID;
    
    public ExchangeObjectRemovedFromBagMessage() { }
    
    public ExchangeObjectRemovedFromBagMessage(boolean remote, int objectUID) {
        super(remote);
        this.objectUID = objectUID;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(objectUID);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        objectUID = buf.readInt();
        if (objectUID < 0)
            throw new RuntimeException("Forbidden value on objectUID = " + objectUID + ", it doesn't respect the following condition : objectUID < 0");
    }
    
}
