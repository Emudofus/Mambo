

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeObjectMovePricedMessage extends ExchangeObjectMoveMessage {
    public static final int MESSAGE_ID = 5514;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int price;
    
    public ExchangeObjectMovePricedMessage() { }
    
    public ExchangeObjectMovePricedMessage(int objectUID, int quantity, int price) {
        super(objectUID, quantity);
        this.price = price;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(price);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        price = buf.readInt();
    }
    
}
