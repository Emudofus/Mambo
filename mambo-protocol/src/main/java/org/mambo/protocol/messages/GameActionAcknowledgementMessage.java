

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionAcknowledgementMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 957;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean valid;
    public byte actionId;
    
    public GameActionAcknowledgementMessage() { }
    
    public GameActionAcknowledgementMessage(boolean valid, byte actionId) {
        this.valid = valid;
        this.actionId = actionId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(valid);
        buf.writeByte(actionId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        valid = buf.readBoolean();
        actionId = buf.readByte();
    }
    
}
