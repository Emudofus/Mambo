

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AbstractGameActionWithAckMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 1001;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short waitAckId;
    
    public AbstractGameActionWithAckMessage() { }
    
    public AbstractGameActionWithAckMessage(short actionId, int sourceId, short waitAckId) {
        super(actionId, sourceId);
        this.waitAckId = waitAckId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(waitAckId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        waitAckId = buf.readShort();
    }
    
}
