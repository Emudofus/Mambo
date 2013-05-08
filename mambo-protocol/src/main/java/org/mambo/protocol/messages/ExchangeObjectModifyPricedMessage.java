

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
    }
    
}
