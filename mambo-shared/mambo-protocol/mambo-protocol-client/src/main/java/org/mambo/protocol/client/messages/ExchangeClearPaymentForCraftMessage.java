

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(paymentType);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        paymentType = reader.readByte();
    }
    
}
