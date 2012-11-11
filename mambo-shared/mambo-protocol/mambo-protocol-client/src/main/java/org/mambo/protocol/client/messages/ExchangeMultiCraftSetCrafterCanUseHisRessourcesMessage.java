

// Generated on 11/11/2012 19:17:10
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
