

// Generated on 05/08/2013 19:37:39
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionFightExchangePositionsMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5527;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public short casterCellId;
    public short targetCellId;
    
    public GameActionFightExchangePositionsMessage() { }
    
    public GameActionFightExchangePositionsMessage(short actionId, int sourceId, int targetId, short casterCellId, short targetCellId) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.casterCellId = casterCellId;
        this.targetCellId = targetCellId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(targetId);
        buf.writeShort(casterCellId);
        buf.writeShort(targetCellId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        targetId = buf.readInt();
        casterCellId = buf.readShort();
        if (casterCellId < -1 || casterCellId > 559)
            throw new RuntimeException("Forbidden value on casterCellId = " + casterCellId + ", it doesn't respect the following condition : casterCellId < -1 || casterCellId > 559");
        targetCellId = buf.readShort();
        if (targetCellId < -1 || targetCellId > 559)
            throw new RuntimeException("Forbidden value on targetCellId = " + targetCellId + ", it doesn't respect the following condition : targetCellId < -1 || targetCellId > 559");
    }
    
}
