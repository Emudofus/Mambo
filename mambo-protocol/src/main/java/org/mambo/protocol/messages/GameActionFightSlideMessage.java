

// Generated on 05/08/2013 19:37:39
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionFightSlideMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5525;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public short startCellId;
    public short endCellId;
    
    public GameActionFightSlideMessage() { }
    
    public GameActionFightSlideMessage(short actionId, int sourceId, int targetId, short startCellId, short endCellId) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.startCellId = startCellId;
        this.endCellId = endCellId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(targetId);
        buf.writeShort(startCellId);
        buf.writeShort(endCellId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        targetId = buf.readInt();
        startCellId = buf.readShort();
        if (startCellId < -1 || startCellId > 559)
            throw new RuntimeException("Forbidden value on startCellId = " + startCellId + ", it doesn't respect the following condition : startCellId < -1 || startCellId > 559");
        endCellId = buf.readShort();
        if (endCellId < -1 || endCellId > 559)
            throw new RuntimeException("Forbidden value on endCellId = " + endCellId + ", it doesn't respect the following condition : endCellId < -1 || endCellId > 559");
    }
    
}
