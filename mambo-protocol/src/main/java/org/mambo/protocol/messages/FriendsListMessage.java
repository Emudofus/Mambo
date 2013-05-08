

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FriendsListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 4002;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public FriendInformations[] friendsList;
    
    public FriendsListMessage() { }
    
    public FriendsListMessage(FriendInformations[] friendsList) {
        this.friendsList = friendsList;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(friendsList.length);
        for (FriendInformations entry : friendsList) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        friendsList = new FriendInformations[limit];
        for (int i = 0; i < limit; i++) {
            friendsList[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            friendsList[i].deserialize(buf);
        }
    }
    
}
