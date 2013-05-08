

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AbstractGameActionMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1000;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short actionId;
    public int sourceId;
    
    public AbstractGameActionMessage() { }
    
    public AbstractGameActionMessage(short actionId, int sourceId) {
        this.actionId = actionId;
        this.sourceId = sourceId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(actionId);
        buf.writeInt(sourceId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        actionId = buf.readShort();
        if (actionId < 0)
            throw new RuntimeException("Forbidden value on actionId = " + actionId + ", it doesn't respect the following condition : actionId < 0");
        sourceId = buf.readInt();
    }
    
}
