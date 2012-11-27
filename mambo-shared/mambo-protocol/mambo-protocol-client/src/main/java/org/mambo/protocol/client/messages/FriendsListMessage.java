

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(friendsList.length);
        for (FriendInformations entry : friendsList) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        friendsList = new FriendInformations[limit];
        for (int i = 0; i < limit; i++) {
            friendsList[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), FriendInformations.class);
            friendsList[i].deserialize(reader);
        }
    }
    
}
