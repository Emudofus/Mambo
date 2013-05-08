

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ChatSmileyRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 800;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte smileyId;
    
    public ChatSmileyRequestMessage() { }
    
    public ChatSmileyRequestMessage(byte smileyId) {
        this.smileyId = smileyId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(smileyId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        smileyId = buf.readByte();
        if (smileyId < 0)
            throw new RuntimeException("Forbidden value on smileyId = " + smileyId + ", it doesn't respect the following condition : smileyId < 0");
    }
    
}
