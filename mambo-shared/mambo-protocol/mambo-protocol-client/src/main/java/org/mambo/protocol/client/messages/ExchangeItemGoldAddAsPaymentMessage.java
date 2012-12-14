

// Generated on 12/14/2012 18:44:13
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(paymentType);
        writer.writeInt(quantity);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        paymentType = reader.readByte();
        quantity = reader.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
    }
    
}
