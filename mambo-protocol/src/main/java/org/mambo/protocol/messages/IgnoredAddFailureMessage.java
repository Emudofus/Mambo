

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class IgnoredAddFailureMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5679;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte reason;
    
    public IgnoredAddFailureMessage() { }
    
    public IgnoredAddFailureMessage(byte reason) {
        this.reason = reason;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(reason);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        reason = buf.readByte();
        if (reason < 0)
            throw new RuntimeException("Forbidden value on reason = " + reason + ", it doesn't respect the following condition : reason < 0");
    }
    
}
