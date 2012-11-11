

// Generated on 11/11/2012 19:17:10
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
