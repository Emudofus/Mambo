

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeBidHouseGenericItemAddedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5947;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objGenericId;
    
    public ExchangeBidHouseGenericItemAddedMessage() { }
    
    public ExchangeBidHouseGenericItemAddedMessage(int objGenericId) {
        this.objGenericId = objGenericId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(objGenericId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        objGenericId = buf.readInt();
    }
    
}
