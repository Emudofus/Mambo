

// Generated on 11/11/2012 20:41:27
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PaddockSellRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5953;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int price;
    
    public PaddockSellRequestMessage() { }
    
    public PaddockSellRequestMessage(int price) {
        this.price = price;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(price);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        price = reader.readInt();
        if (price < 0)
            throw new RuntimeException("Forbidden value on price = " + price + ", it doesn't respect the following condition : price < 0");
    }
    
}
