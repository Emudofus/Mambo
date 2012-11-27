

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeMultiCraftCrafterCanUseHisRessourcesMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6020;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean allowed;
    
    public ExchangeMultiCraftCrafterCanUseHisRessourcesMessage() { }
    
    public ExchangeMultiCraftCrafterCanUseHisRessourcesMessage(boolean allowed) {
        this.allowed = allowed;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(allowed);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        allowed = reader.readBoolean();
    }
    
}
