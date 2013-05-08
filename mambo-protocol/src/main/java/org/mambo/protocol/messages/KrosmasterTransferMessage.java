

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class KrosmasterTransferMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6348;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String uid;
    public byte failure;
    
    public KrosmasterTransferMessage() { }
    
    public KrosmasterTransferMessage(String uid, byte failure) {
        this.uid = uid;
        this.failure = failure;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(uid);
        buf.writeByte(failure);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        uid = buf.readString();
        failure = buf.readByte();
        if (failure < 0)
            throw new RuntimeException("Forbidden value on failure = " + failure + ", it doesn't respect the following condition : failure < 0");
    }
    
}
