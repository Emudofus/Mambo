

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TeleportOnSameMapMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6048;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public short cellId;
    
    public TeleportOnSameMapMessage() { }
    
    public TeleportOnSameMapMessage(int targetId, short cellId) {
        this.targetId = targetId;
        this.cellId = cellId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(targetId);
        buf.writeShort(cellId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        targetId = buf.readInt();
        cellId = buf.readShort();
        if (cellId < 0 || cellId > 559)
            throw new RuntimeException("Forbidden value on cellId = " + cellId + ", it doesn't respect the following condition : cellId < 0 || cellId > 559");
    }
    
}
