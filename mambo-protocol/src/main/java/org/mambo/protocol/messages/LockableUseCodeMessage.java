

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class LockableUseCodeMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5667;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String code;
    
    public LockableUseCodeMessage() { }
    
    public LockableUseCodeMessage(String code) {
        this.code = code;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(code);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        code = buf.readString();
    }
    
}
