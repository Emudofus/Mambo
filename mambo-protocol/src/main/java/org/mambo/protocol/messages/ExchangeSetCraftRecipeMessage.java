

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeSetCraftRecipeMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6389;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short objectGID;
    
    public ExchangeSetCraftRecipeMessage() { }
    
    public ExchangeSetCraftRecipeMessage(short objectGID) {
        this.objectGID = objectGID;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(objectGID);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        objectGID = buf.readShort();
        if (objectGID < 0)
            throw new RuntimeException("Forbidden value on objectGID = " + objectGID + ", it doesn't respect the following condition : objectGID < 0");
    }
    
}
