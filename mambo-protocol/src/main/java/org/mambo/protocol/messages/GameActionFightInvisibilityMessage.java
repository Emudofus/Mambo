

// Generated on 05/08/2013 19:37:39
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionFightInvisibilityMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5821;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public byte state;
    
    public GameActionFightInvisibilityMessage() { }
    
    public GameActionFightInvisibilityMessage(short actionId, int sourceId, int targetId, byte state) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.state = state;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(targetId);
        buf.writeByte(state);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        targetId = buf.readInt();
        state = buf.readByte();
    }
    
}
