

// Generated on 05/08/2013 19:37:39
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionFightModifyEffectsDurationMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 6304;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public short delta;
    
    public GameActionFightModifyEffectsDurationMessage() { }
    
    public GameActionFightModifyEffectsDurationMessage(short actionId, int sourceId, int targetId, short delta) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.delta = delta;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(targetId);
        buf.writeShort(delta);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        targetId = buf.readInt();
        delta = buf.readShort();
    }
    
}
