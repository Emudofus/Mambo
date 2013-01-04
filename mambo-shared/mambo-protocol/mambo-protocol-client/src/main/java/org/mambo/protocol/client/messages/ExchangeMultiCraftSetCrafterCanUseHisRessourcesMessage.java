

// Generated on 01/04/2013 14:54:38
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
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
