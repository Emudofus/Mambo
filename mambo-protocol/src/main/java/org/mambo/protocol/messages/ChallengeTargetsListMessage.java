

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ChallengeTargetsListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5613;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] targetIds;
    public short[] targetCells;
    
    public ChallengeTargetsListMessage() { }
    
    public ChallengeTargetsListMessage(int[] targetIds, short[] targetCells) {
        this.targetIds = targetIds;
        this.targetCells = targetCells;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(targetIds.length);
        for (int entry : targetIds) {
            buf.writeInt(entry);
        }
        buf.writeUShort(targetCells.length);
        for (short entry : targetCells) {
            buf.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        targetIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            targetIds[i] = buf.readInt();
        }
        limit = buf.readUShort();
        targetCells = new short[limit];
        for (int i = 0; i < limit; i++) {
            targetCells[i] = buf.readShort();
        }
    }
    
}
