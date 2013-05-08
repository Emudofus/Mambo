

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeStartOkNpcTradeMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5785;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int npcId;
    
    public ExchangeStartOkNpcTradeMessage() { }
    
    public ExchangeStartOkNpcTradeMessage(int npcId) {
        this.npcId = npcId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(npcId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        npcId = buf.readInt();
    }
    
}
