

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class IgnoredAddRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5673;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String name;
    public boolean session;
    
    public IgnoredAddRequestMessage() { }
    
    public IgnoredAddRequestMessage(String name, boolean session) {
        this.name = name;
        this.session = session;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(name);
        buf.writeBoolean(session);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        name = buf.readString();
        session = buf.readBoolean();
    }
    
}
