

// Generated on 11/11/2012 20:41:25
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ChannelEnablingChangeMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 891;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte channel;
    public boolean enable;
    
    public ChannelEnablingChangeMessage() { }
    
    public ChannelEnablingChangeMessage(byte channel, boolean enable) {
        this.channel = channel;
        this.enable = enable;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(channel);
        writer.writeBoolean(enable);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        channel = reader.readByte();
        if (channel < 0)
            throw new RuntimeException("Forbidden value on channel = " + channel + ", it doesn't respect the following condition : channel < 0");
        enable = reader.readBoolean();
    }
    
}
