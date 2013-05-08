

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeCraftResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5790;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte craftResult;
    
    public ExchangeCraftResultMessage() { }
    
    public ExchangeCraftResultMessage(byte craftResult) {
        this.craftResult = craftResult;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(craftResult);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        craftResult = buf.readByte();
        if (craftResult < 0)
            throw new RuntimeException("Forbidden value on craftResult = " + craftResult + ", it doesn't respect the following condition : craftResult < 0");
    }
    
}
