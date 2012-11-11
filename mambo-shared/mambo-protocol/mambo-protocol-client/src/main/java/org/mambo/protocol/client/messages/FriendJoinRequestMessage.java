

// Generated on 11/11/2012 20:41:30
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class FriendJoinRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5605;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String name;
    
    public FriendJoinRequestMessage() { }
    
    public FriendJoinRequestMessage(String name) {
        this.name = name;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(name);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        name = reader.readString();
    }
    
}
