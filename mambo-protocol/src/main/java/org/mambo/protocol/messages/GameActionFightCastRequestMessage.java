

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeShort(spellId);
        buf.writeShort(cellId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        spellId = buf.readShort();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
        cellId = buf.readShort();
        if (cellId < -1 || cellId > 559)
            throw new RuntimeException("Forbidden value on cellId = " + cellId + ", it doesn't respect the following condition : cellId < -1 || cellId > 559");
    }
    
}
