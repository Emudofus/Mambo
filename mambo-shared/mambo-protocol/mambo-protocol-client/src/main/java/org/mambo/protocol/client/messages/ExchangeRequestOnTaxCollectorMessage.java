

// Generated on 12/14/2012 18:44:15
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeRequestOnTaxCollectorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5779;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int taxCollectorId;
    
    public ExchangeRequestOnTaxCollectorMessage() { }
    
    public ExchangeRequestOnTaxCollectorMessage(int taxCollectorId) {
        this.taxCollectorId = taxCollectorId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(taxCollectorId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        taxCollectorId = reader.readInt();
    }
    
}
