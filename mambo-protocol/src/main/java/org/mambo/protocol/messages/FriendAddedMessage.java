

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FriendAddedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5599;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public FriendInformations friendAdded;
    
    public FriendAddedMessage() { }
    
    public FriendAddedMessage(FriendInformations friendAdded) {
        this.friendAdded = friendAdded;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(friendAdded.getTypeId());
        friendAdded.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        friendAdded = ProtocolTypeManager.getInstance().build(buf.readShort());
        friendAdded.deserialize(buf);
    }
    
}
