

// Generated on 11/11/2012 20:41:25
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class MoodSmileyRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6192;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte smileyId;
    
    public MoodSmileyRequestMessage() { }
    
    public MoodSmileyRequestMessage(byte smileyId) {
        this.smileyId = smileyId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(smileyId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        smileyId = reader.readByte();
    }
    
}
