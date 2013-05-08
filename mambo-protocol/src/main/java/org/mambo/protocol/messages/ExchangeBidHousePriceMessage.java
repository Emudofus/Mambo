

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeBidHousePriceMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5805;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int genId;
    
    public ExchangeBidHousePriceMessage() { }
    
    public ExchangeBidHousePriceMessage(int genId) {
        this.genId = genId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(genId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        genId = buf.readInt();
        if (genId < 0)
            throw new RuntimeException("Forbidden value on genId = " + genId + ", it doesn't respect the following condition : genId < 0");
    }
    
}
