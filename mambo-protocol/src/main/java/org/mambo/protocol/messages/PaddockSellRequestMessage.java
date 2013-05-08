

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeInt(price);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        price = buf.readInt();
        if (price < 0)
            throw new RuntimeException("Forbidden value on price = " + price + ", it doesn't respect the following condition : price < 0");
    }
    
}
