

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class LockableCodeResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5672;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte result;
    
    public LockableCodeResultMessage() { }
    
    public LockableCodeResultMessage(byte result) {
        this.result = result;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(result);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        result = buf.readByte();
        if (result < 0)
            throw new RuntimeException("Forbidden value on result = " + result + ", it doesn't respect the following condition : result < 0");
    }
    
}
