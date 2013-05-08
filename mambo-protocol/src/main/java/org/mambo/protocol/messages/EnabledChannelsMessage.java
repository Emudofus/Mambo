

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class EnabledChannelsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 892;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte[] channels;
    public byte[] disallowed;
    
    public EnabledChannelsMessage() { }
    
    public EnabledChannelsMessage(byte[] channels, byte[] disallowed) {
        this.channels = channels;
        this.disallowed = disallowed;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(channels.length);
        for (byte entry : channels) {
            buf.writeByte(entry);
        }
        buf.writeUShort(disallowed.length);
        for (byte entry : disallowed) {
            buf.writeByte(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        channels = new byte[limit];
        for (int i = 0; i < limit; i++) {
            channels[i] = buf.readByte();
        }
        limit = buf.readUShort();
        disallowed = new byte[limit];
        for (int i = 0; i < limit; i++) {
            disallowed[i] = buf.readByte();
        }
    }
    
}
