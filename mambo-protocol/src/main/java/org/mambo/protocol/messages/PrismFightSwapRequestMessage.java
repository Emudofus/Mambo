

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PrismFightSwapRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5901;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    
    public PrismFightSwapRequestMessage() { }
    
    public PrismFightSwapRequestMessage(int targetId) {
        this.targetId = targetId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(targetId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        targetId = buf.readInt();
        if (targetId < 0)
            throw new RuntimeException("Forbidden value on targetId = " + targetId + ", it doesn't respect the following condition : targetId < 0");
    }
    
}
