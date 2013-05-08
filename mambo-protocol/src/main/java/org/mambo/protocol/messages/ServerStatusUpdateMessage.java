

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        server.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        server = new GameServerInformations();
        server.deserialize(buf);
    }
    
}
