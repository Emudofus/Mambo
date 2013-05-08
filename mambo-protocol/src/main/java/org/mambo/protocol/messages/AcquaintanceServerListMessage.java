

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeUShort(servers.length);
        for (short entry : servers) {
            buf.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        servers = new short[limit];
        for (int i = 0; i < limit; i++) {
            servers[i] = buf.readShort();
        }
    }
    
}
