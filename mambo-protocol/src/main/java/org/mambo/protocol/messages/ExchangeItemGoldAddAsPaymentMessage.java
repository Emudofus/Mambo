

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeItemGoldAddAsPaymentMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5770;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte paymentType;
    public int quantity;
    
    public ExchangeItemGoldAddAsPaymentMessage() { }
    
    public ExchangeItemGoldAddAsPaymentMessage(byte paymentType, int quantity) {
        this.paymentType = paymentType;
        this.quantity = quantity;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(paymentType);
        buf.writeInt(quantity);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        paymentType = buf.readByte();
        quantity = buf.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
    }
    
}
