

// Generated on 11/11/2012 20:41:33
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class TaxCollectorMovementRemoveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5915;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int collectorId;
    
    public TaxCollectorMovementRemoveMessage() { }
    
    public TaxCollectorMovementRemoveMessage(int collectorId) {
        this.collectorId = collectorId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(collectorId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        collectorId = reader.readInt();
    }
    
}
