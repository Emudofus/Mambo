

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class EmotePlayRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5685;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte emoteId;
    
    public EmotePlayRequestMessage() { }
    
    public EmotePlayRequestMessage(byte emoteId) {
        this.emoteId = emoteId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(emoteId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        emoteId = buf.readByte();
        if (emoteId < 0)
            throw new RuntimeException("Forbidden value on emoteId = " + emoteId + ", it doesn't respect the following condition : emoteId < 0");
    }
    
}
