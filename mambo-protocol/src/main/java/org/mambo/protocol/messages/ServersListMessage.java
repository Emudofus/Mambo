

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ServersListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 30;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public GameServerInformations[] servers;
    
    public ServersListMessage() { }
    
    public ServersListMessage(GameServerInformations[] servers) {
        this.servers = servers;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(servers.length);
        for (GameServerInformations entry : servers) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        servers = new GameServerInformations[limit];
        for (int i = 0; i < limit; i++) {
            servers[i] = new GameServerInformations();
            servers[i].deserialize(buf);
        }
    }
    
}
