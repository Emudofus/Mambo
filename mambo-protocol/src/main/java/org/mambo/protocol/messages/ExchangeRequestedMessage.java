

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeRequestedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5522;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte exchangeType;
    
    public ExchangeRequestedMessage() { }
    
    public ExchangeRequestedMessage(byte exchangeType) {
        this.exchangeType = exchangeType;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(exchangeType);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        exchangeType = buf.readByte();
    }
    
}
