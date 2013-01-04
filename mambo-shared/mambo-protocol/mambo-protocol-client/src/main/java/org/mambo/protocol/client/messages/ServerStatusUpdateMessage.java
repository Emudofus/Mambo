

// Generated on 01/04/2013 14:54:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ServerStatusUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 50;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public GameServerInformations server;
    
    public ServerStatusUpdateMessage() { }
    
    public ServerStatusUpdateMessage(GameServerInformations server) {
        this.server = server;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        server.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        server = new GameServerInformations();
        server.deserialize(reader);
    }
    
}
