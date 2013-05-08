

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeString(name);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        name = buf.readString();
    }
    
}
