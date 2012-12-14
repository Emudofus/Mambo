

// Generated on 12/14/2012 18:44:07
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(targetId);
        writer.writeShort(targetCellId);
        writer.writeBoolean(friendly);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        targetId = reader.readInt();
        if (targetId < 0)
            throw new RuntimeException("Forbidden value on targetId = " + targetId + ", it doesn't respect the following condition : targetId < 0");
        targetCellId = reader.readShort();
        if (targetCellId < -1 || targetCellId > 559)
            throw new RuntimeException("Forbidden value on targetCellId = " + targetCellId + ", it doesn't respect the following condition : targetCellId < -1 || targetCellId > 559");
        friendly = reader.readBoolean();
    }
    
}
