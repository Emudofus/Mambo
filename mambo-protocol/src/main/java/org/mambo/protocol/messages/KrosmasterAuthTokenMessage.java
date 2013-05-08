

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class KrosmasterAuthTokenMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6351;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String token;
    
    public KrosmasterAuthTokenMessage() { }
    
    public KrosmasterAuthTokenMessage(String token) {
        this.token = token;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(token);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        token = buf.readString();
    }
    
}
