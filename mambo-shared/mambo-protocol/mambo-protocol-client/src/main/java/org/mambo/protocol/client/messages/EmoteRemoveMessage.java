

// Generated on 01/04/2013 14:54:25
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class EmoteRemoveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5687;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte emoteId;
    
    public EmoteRemoveMessage() { }
    
    public EmoteRemoveMessage(byte emoteId) {
        this.emoteId = emoteId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(emoteId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        emoteId = reader.readByte();
        if (emoteId < 0)
            throw new RuntimeException("Forbidden value on emoteId = " + emoteId + ", it doesn't respect the following condition : emoteId < 0");
    }
    
}
