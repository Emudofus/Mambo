

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeClearPaymentForCraftMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6145;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte paymentType;
    
    public ExchangeClearPaymentForCraftMessage() { }
    
    public ExchangeClearPaymentForCraftMessage(byte paymentType) {
        this.paymentType = paymentType;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(paymentType);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        paymentType = buf.readByte();
    }
    
}
