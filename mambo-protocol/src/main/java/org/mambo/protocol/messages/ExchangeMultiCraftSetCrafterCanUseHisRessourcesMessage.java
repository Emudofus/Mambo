

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeBoolean(allow);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        allow = buf.readBoolean();
    }
    
}
