

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
    }
    
}
