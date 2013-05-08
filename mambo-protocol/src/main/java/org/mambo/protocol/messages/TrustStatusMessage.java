

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TrustStatusMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6267;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean trusted;
    
    public TrustStatusMessage() { }
    
    public TrustStatusMessage(boolean trusted) {
        this.trusted = trusted;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(trusted);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        trusted = buf.readBoolean();
    }
    
}
