

// Generated on 11/11/2012 20:41:35
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeObjectModifyPricedMessage extends ExchangeObjectMovePricedMessage {
    public static final int MESSAGE_ID = 6238;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public ExchangeObjectModifyPricedMessage() { }
    
    public ExchangeObjectModifyPricedMessage(int objectUID, int quantity, int price) {
        super(objectUID, quantity, price);
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
