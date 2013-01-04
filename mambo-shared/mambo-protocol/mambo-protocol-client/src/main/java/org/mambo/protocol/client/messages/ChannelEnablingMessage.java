

// Generated on 01/04/2013 14:54:22
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ChannelEnablingMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 890;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte channel;
    public boolean enable;
    
    public ChannelEnablingMessage() { }
    
    public ChannelEnablingMessage(byte channel, boolean enable) {
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
