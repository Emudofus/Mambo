

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeBidHouseItemRemoveOkMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5946;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int sellerId;
    
    public ExchangeBidHouseItemRemoveOkMessage() { }
    
    public ExchangeBidHouseItemRemoveOkMessage(int sellerId) {
        this.sellerId = sellerId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(sellerId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        sellerId = buf.readInt();
    }
    
}
