

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class BasicAckMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6362;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int seq;
    public short lastPacketId;
    
    public BasicAckMessage() { }
    
    public BasicAckMessage(int seq, short lastPacketId) {
        this.seq = seq;
        this.lastPacketId = lastPacketId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(seq);
        buf.writeShort(lastPacketId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        seq = buf.readInt();
        if (seq < 0)
            throw new RuntimeException("Forbidden value on seq = " + seq + ", it doesn't respect the following condition : seq < 0");
        lastPacketId = buf.readShort();
        if (lastPacketId < 0)
            throw new RuntimeException("Forbidden value on lastPacketId = " + lastPacketId + ", it doesn't respect the following condition : lastPacketId < 0");
    }
    
}
