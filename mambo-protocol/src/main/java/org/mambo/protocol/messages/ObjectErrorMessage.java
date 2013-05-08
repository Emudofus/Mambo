

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectErrorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 3004;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte reason;
    
    public ObjectErrorMessage() { }
    
    public ObjectErrorMessage(byte reason) {
        this.reason = reason;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(reason);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        reason = buf.readByte();
    }
    
}
