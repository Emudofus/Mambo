

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionFightStateChangeMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5569;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public short stateId;
    public boolean active;
    
    public GameActionFightStateChangeMessage() { }
    
    public GameActionFightStateChangeMessage(short actionId, int sourceId, int targetId, short stateId, boolean active) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.stateId = stateId;
        this.active = active;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(targetId);
        buf.writeShort(stateId);
        buf.writeBoolean(active);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        targetId = buf.readInt();
        stateId = buf.readShort();
        active = buf.readBoolean();
    }
    
}
