

// Generated on 11/11/2012 20:41:22
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameActionFightCastRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1005;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short spellId;
    public short cellId;
    
    public GameActionFightCastRequestMessage() { }
    
    public GameActionFightCastRequestMessage(short spellId, short cellId) {
        this.spellId = spellId;
        this.cellId = cellId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(spellId);
        writer.writeShort(cellId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        spellId = reader.readShort();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
        cellId = reader.readShort();
        if (cellId < -1 || cellId > 559)
            throw new RuntimeException("Forbidden value on cellId = " + cellId + ", it doesn't respect the following condition : cellId < -1 || cellId > 559");
    }
    
}
