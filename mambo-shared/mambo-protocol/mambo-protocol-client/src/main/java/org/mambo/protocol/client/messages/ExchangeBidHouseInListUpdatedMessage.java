

// Generated on 12/14/2012 18:44:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
