

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class KrosmasterTransferRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6349;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String uid;
    
    public KrosmasterTransferRequestMessage() { }
    
    public KrosmasterTransferRequestMessage(String uid) {
        this.uid = uid;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(uid);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        uid = buf.readString();
    }
    
}
