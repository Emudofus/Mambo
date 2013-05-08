

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeShort(spellId);
        buf.writeInt(targetId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        spellId = buf.readShort();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
        targetId = buf.readInt();
    }
    
}
