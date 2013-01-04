

// Generated on 01/04/2013 14:54:22
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(channels.length);
        for (byte entry : channels) {
            writer.writeByte(entry);
        }
        writer.writeUnsignedShort(disallowed.length);
        for (byte entry : disallowed) {
            writer.writeByte(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        channels = new byte[limit];
        for (int i = 0; i < limit; i++) {
            channels[i] = reader.readByte();
        }
        limit = reader.readUnsignedShort();
        disallowed = new byte[limit];
        for (int i = 0; i < limit; i++) {
            disallowed[i] = reader.readByte();
        }
    }
    
}
