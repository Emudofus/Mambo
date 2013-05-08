

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class IgnoredAddedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5678;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public IgnoredInformations ignoreAdded;
    public boolean session;
    
    public IgnoredAddedMessage() { }
    
    public IgnoredAddedMessage(IgnoredInformations ignoreAdded, boolean session) {
        this.ignoreAdded = ignoreAdded;
        this.session = session;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(ignoreAdded.getTypeId());
        ignoreAdded.serialize(buf);
        buf.writeBoolean(session);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        ignoreAdded = ProtocolTypeManager.getInstance().build(buf.readShort());
        ignoreAdded.deserialize(buf);
        session = buf.readBoolean();
    }
    
}
