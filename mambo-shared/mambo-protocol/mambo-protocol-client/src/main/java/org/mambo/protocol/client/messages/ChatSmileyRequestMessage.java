

// Generated on 01/04/2013 14:54:22
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(smileyId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        smileyId = reader.readByte();
        if (smileyId < 0)
            throw new RuntimeException("Forbidden value on smileyId = " + smileyId + ", it doesn't respect the following condition : smileyId < 0");
    }
    
}
