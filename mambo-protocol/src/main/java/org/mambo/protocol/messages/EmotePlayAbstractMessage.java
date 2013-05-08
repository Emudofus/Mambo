

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class EmotePlayAbstractMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5690;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte emoteId;
    public double emoteStartTime;
    
    public EmotePlayAbstractMessage() { }
    
    public EmotePlayAbstractMessage(byte emoteId, double emoteStartTime) {
        this.emoteId = emoteId;
        this.emoteStartTime = emoteStartTime;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(emoteId);
        buf.writeDouble(emoteStartTime);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        emoteId = buf.readByte();
        if (emoteId < 0)
            throw new RuntimeException("Forbidden value on emoteId = " + emoteId + ", it doesn't respect the following condition : emoteId < 0");
        emoteStartTime = buf.readDouble();
    }
    
}
