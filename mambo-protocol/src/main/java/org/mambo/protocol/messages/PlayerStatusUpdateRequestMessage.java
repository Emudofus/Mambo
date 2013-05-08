

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PlayerStatusUpdateRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6387;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public PlayerStatus status;
    
    public PlayerStatusUpdateRequestMessage() { }
    
    public PlayerStatusUpdateRequestMessage(PlayerStatus status) {
        this.status = status;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(status.getTypeId());
        status.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        status = ProtocolTypeManager.getInstance().build(buf.readShort());
        status.deserialize(buf);
    }
    
}
