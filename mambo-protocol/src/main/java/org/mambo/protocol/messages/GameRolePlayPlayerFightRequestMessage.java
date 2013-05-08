

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayPlayerFightRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5731;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public short targetCellId;
    public boolean friendly;
    
    public GameRolePlayPlayerFightRequestMessage() { }
    
    public GameRolePlayPlayerFightRequestMessage(int targetId, short targetCellId, boolean friendly) {
        this.targetId = targetId;
        this.targetCellId = targetCellId;
        this.friendly = friendly;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(targetId);
        buf.writeShort(targetCellId);
        buf.writeBoolean(friendly);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        targetId = buf.readInt();
        if (targetId < 0)
            throw new RuntimeException("Forbidden value on targetId = " + targetId + ", it doesn't respect the following condition : targetId < 0");
        targetCellId = buf.readShort();
        if (targetCellId < -1 || targetCellId > 559)
            throw new RuntimeException("Forbidden value on targetCellId = " + targetCellId + ", it doesn't respect the following condition : targetCellId < -1 || targetCellId > 559");
        friendly = buf.readBoolean();
    }
    
}
