

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionFightChangeLookMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5532;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public EntityLook entityLook;
    
    public GameActionFightChangeLookMessage() { }
    
    public GameActionFightChangeLookMessage(short actionId, int sourceId, int targetId, EntityLook entityLook) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.entityLook = entityLook;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(targetId);
        entityLook.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        targetId = buf.readInt();
        entityLook = new EntityLook();
        entityLook.deserialize(buf);
    }
    
}
