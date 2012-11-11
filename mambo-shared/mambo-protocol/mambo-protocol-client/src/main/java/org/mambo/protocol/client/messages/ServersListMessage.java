

// Generated on 11/11/2012 19:16:57
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(servers.length);
        for (GameServerInformations entry : servers) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        servers = new GameServerInformations[limit];
        for (int i = 0; i < limit; i++) {
            servers[i] = new GameServerInformations();
            servers[i].deserialize(reader);
        }
    }
    
}
