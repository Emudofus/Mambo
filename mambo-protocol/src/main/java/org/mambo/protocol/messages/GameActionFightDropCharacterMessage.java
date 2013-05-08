

// Generated on 05/08/2013 19:37:39
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionFightDropCharacterMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5826;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public short cellId;
    
    public GameActionFightDropCharacterMessage() { }
    
    public GameActionFightDropCharacterMessage(short actionId, int sourceId, int targetId, short cellId) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.cellId = cellId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(targetId);
        buf.writeShort(cellId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        targetId = buf.readInt();
        cellId = buf.readShort();
        if (cellId < -1 || cellId > 559)
            throw new RuntimeException("Forbidden value on cellId = " + cellId + ", it doesn't respect the following condition : cellId < -1 || cellId > 559");
    }
    
}
