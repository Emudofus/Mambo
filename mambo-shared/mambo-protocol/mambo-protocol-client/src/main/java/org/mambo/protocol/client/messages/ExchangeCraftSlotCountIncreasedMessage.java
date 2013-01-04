

// Generated on 01/04/2013 14:54:35
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(newMaxSlot);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        newMaxSlot = reader.readByte();
        if (newMaxSlot < 0)
            throw new RuntimeException("Forbidden value on newMaxSlot = " + newMaxSlot + ", it doesn't respect the following condition : newMaxSlot < 0");
    }
    
}
