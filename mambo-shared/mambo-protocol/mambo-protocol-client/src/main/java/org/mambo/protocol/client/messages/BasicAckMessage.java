

// Generated on 01/04/2013 14:54:20
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(seq);
        writer.writeShort(lastPacketId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        seq = reader.readInt();
        if (seq < 0)
            throw new RuntimeException("Forbidden value on seq = " + seq + ", it doesn't respect the following condition : seq < 0");
        lastPacketId = reader.readShort();
        if (lastPacketId < 0)
            throw new RuntimeException("Forbidden value on lastPacketId = " + lastPacketId + ", it doesn't respect the following condition : lastPacketId < 0");
    }
    
}
