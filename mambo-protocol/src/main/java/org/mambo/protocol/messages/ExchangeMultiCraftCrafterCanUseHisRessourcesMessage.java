

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeBoolean(allowed);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        allowed = buf.readBoolean();
    }
    
}
