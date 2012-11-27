

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(friendUpdated.getTypeId());
        friendUpdated.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        friendUpdated = ProtocolTypeManager.getInstance().build(reader.readShort(), FriendInformations.class);
        friendUpdated.deserialize(reader);
    }
    
}
