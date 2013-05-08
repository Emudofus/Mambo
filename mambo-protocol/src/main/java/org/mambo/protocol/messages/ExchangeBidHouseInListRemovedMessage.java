

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeBidHouseInListRemovedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5950;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int itemUID;
    
    public ExchangeBidHouseInListRemovedMessage() { }
    
    public ExchangeBidHouseInListRemovedMessage(int itemUID) {
        this.itemUID = itemUID;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(itemUID);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        itemUID = buf.readInt();
    }
    
}
