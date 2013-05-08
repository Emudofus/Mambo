

// Generated on 05/08/2013 19:37:39
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionFightInvisibleObstacleMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5820;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int sourceSpellId;
    
    public GameActionFightInvisibleObstacleMessage() { }
    
    public GameActionFightInvisibleObstacleMessage(short actionId, int sourceId, int sourceSpellId) {
        super(actionId, sourceId);
        this.sourceSpellId = sourceSpellId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(sourceSpellId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        sourceSpellId = buf.readInt();
        if (sourceSpellId < 0)
            throw new RuntimeException("Forbidden value on sourceSpellId = " + sourceSpellId + ", it doesn't respect the following condition : sourceSpellId < 0");
    }
    
}
