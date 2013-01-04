

// Generated on 01/04/2013 14:54:31
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class FriendAddRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 4004;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String name;
    
    public FriendAddRequestMessage() { }
    
    public FriendAddRequestMessage(String name) {
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
