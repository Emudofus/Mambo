

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeByte(channel);
        buf.writeBoolean(enable);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        channel = buf.readByte();
        if (channel < 0)
            throw new RuntimeException("Forbidden value on channel = " + channel + ", it doesn't respect the following condition : channel < 0");
        enable = buf.readBoolean();
    }
    
}
