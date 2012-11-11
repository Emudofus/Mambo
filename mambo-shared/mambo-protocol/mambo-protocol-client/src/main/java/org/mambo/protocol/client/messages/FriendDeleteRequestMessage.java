

// Generated on 11/11/2012 19:17:07
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class FriendDeleteRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5603;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String name;
    
    public FriendDeleteRequestMessage() { }
    
    public FriendDeleteRequestMessage(String name) {
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
