

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeCraftSlotCountIncreasedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6125;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte newMaxSlot;
    
    public ExchangeCraftSlotCountIncreasedMessage() { }
    
    public ExchangeCraftSlotCountIncreasedMessage(byte newMaxSlot) {
        this.newMaxSlot = newMaxSlot;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(newMaxSlot);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        newMaxSlot = buf.readByte();
        if (newMaxSlot < 0)
            throw new RuntimeException("Forbidden value on newMaxSlot = " + newMaxSlot + ", it doesn't respect the following condition : newMaxSlot < 0");
    }
    
}
