

// Generated on 12/14/2012 18:44:07
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(emoteId);
        writer.writeDouble(emoteStartTime);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        emoteId = reader.readByte();
        if (emoteId < 0)
            throw new RuntimeException("Forbidden value on emoteId = " + emoteId + ", it doesn't respect the following condition : emoteId < 0");
        emoteStartTime = reader.readDouble();
    }
    
}
