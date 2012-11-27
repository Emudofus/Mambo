

// Generated on 11/11/2012 20:41:22
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameActionFightCastOnTargetRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6330;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short spellId;
    public int targetId;
    
    public GameActionFightCastOnTargetRequestMessage() { }
    
    public GameActionFightCastOnTargetRequestMessage(short spellId, int targetId) {
        this.spellId = spellId;
        this.targetId = targetId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(spellId);
        writer.writeInt(targetId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        spellId = reader.readShort();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
        targetId = reader.readInt();
    }
    
}
