

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ServerSelectionMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 40;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short serverId;
    
    public ServerSelectionMessage() { }
    
    public ServerSelectionMessage(short serverId) {
        this.serverId = serverId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(serverId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        serverId = buf.readShort();
    }
    
}
