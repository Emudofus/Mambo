

// Generated on 01/04/2013 14:54:31
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class FriendDeleteResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5601;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean success;
    public String name;
    
    public FriendDeleteResultMessage() { }
    
    public FriendDeleteResultMessage(boolean success, String name) {
        this.success = success;
        this.name = name;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(success);
        writer.writeString(name);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        success = reader.readBoolean();
        name = reader.readString();
    }
    
}
