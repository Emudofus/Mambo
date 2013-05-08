

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeWaitingResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5786;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean bwait;
    
    public ExchangeWaitingResultMessage() { }
    
    public ExchangeWaitingResultMessage(boolean bwait) {
        this.bwait = bwait;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(bwait);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        bwait = buf.readBoolean();
    }
    
}
