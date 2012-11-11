

// Generated on 11/11/2012 20:41:22
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
