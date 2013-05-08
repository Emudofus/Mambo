

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeBoolean(success);
        buf.writeString(name);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        success = buf.readBoolean();
        name = buf.readString();
    }
    
}
