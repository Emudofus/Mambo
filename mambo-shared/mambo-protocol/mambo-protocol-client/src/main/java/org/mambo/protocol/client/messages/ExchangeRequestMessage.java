

// Generated on 01/04/2013 14:54:36
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

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
