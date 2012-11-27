

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeMultiCraftSetCrafterCanUseHisRessourcesMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6021;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean allow;
    
    public ExchangeMultiCraftSetCrafterCanUseHisRessourcesMessage() { }
    
    public ExchangeMultiCraftSetCrafterCanUseHisRessourcesMessage(boolean allow) {
        this.allow = allow;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(allow);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        allow = reader.readBoolean();
    }
    
}
