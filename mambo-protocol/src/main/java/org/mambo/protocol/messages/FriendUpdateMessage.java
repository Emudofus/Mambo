

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FriendUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5924;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public FriendInformations friendUpdated;
    
    public FriendUpdateMessage() { }
    
    public FriendUpdateMessage(FriendInformations friendUpdated) {
        this.friendUpdated = friendUpdated;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(friendUpdated.getTypeId());
        friendUpdated.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        friendUpdated = ProtocolTypeManager.getInstance().build(buf.readShort());
        friendUpdated.deserialize(buf);
    }
    
}
