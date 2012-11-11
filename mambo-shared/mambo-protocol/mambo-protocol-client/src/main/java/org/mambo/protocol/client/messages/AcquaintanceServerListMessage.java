

// Generated on 11/11/2012 19:16:57
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class AcquaintanceServerListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6142;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] servers;
    
    public AcquaintanceServerListMessage() { }
    
    public AcquaintanceServerListMessage(short[] servers) {
        this.servers = servers;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(servers.length);
        for (short entry : servers) {
            writer.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        servers = new short[limit];
        for (int i = 0; i < limit; i++) {
            servers[i] = reader.readShort();
        }
    }
    
}
