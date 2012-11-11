

// Generated on 11/11/2012 19:17:09
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeObjectMoveKamaMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5520;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int quantity;
    
    public ExchangeObjectMoveKamaMessage() { }
    
    public ExchangeObjectMoveKamaMessage(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(quantity);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        quantity = reader.readInt();
    }
    
}
