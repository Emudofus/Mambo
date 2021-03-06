

// Generated on 05/08/2013 19:37:37
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class BasicPongMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 183;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean quiet;
    
    public BasicPongMessage() { }
    
    public BasicPongMessage(boolean quiet) {
        this.quiet = quiet;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(quiet);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        quiet = buf.readBoolean();
    }
    
}
