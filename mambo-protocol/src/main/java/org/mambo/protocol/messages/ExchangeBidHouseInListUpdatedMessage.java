

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeBidHouseInListUpdatedMessage extends ExchangeBidHouseInListAddedMessage {
    public static final int MESSAGE_ID = 6337;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public ExchangeBidHouseInListUpdatedMessage() { }
    
    public ExchangeBidHouseInListUpdatedMessage(int itemUID, int objGenericId, short powerRate, boolean overMax, ObjectEffect[] effects, int[] prices) {
        super(itemUID, objGenericId, powerRate, overMax, effects, prices);
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
    }
    
}
