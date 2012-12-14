

// Generated on 12/14/2012 18:44:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(friendAdded.getTypeId());
        friendAdded.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        friendAdded = ProtocolTypeManager.getInstance().build(reader.readShort(), FriendInformations.class);
        friendAdded.deserialize(reader);
    }
    
}
