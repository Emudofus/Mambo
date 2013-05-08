

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeObjectMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5515;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean remote;
    
    public ExchangeObjectMessage() { }
    
    public ExchangeObjectMessage(boolean remote) {
        this.remote = remote;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(remote);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        remote = buf.readBoolean();
    }
    
}
