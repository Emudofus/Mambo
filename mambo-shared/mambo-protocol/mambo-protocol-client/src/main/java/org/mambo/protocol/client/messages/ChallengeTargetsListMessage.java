

// Generated on 11/11/2012 19:17:01
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(targetIds.length);
        for (int entry : targetIds) {
            writer.writeInt(entry);
        }
        writer.writeUnsignedShort(targetCells.length);
        for (short entry : targetCells) {
            writer.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        targetIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            targetIds[i] = reader.readInt();
        }
        limit = reader.readUnsignedShort();
        targetCells = new short[limit];
        for (int i = 0; i < limit; i++) {
            targetCells[i] = reader.readShort();
        }
    }
    
}
