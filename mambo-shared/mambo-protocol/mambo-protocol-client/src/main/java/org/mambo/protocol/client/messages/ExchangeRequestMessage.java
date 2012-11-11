

// Generated on 11/11/2012 20:41:35
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5505;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte exchangeType;
    
    public ExchangeRequestMessage() { }
    
    public ExchangeRequestMessage(byte exchangeType) {
        this.exchangeType = exchangeType;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(exchangeType);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        exchangeType = reader.readByte();
    }
    
}
