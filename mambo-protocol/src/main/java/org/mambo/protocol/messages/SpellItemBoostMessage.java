

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SpellItemBoostMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6011;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int statId;
    public short spellId;
    public short value;
    
    public SpellItemBoostMessage() { }
    
    public SpellItemBoostMessage(int statId, short spellId, short value) {
        this.statId = statId;
        this.spellId = spellId;
        this.value = value;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(statId);
        buf.writeShort(spellId);
        buf.writeShort(value);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        statId = buf.readInt();
        if (statId < 0)
            throw new RuntimeException("Forbidden value on statId = " + statId + ", it doesn't respect the following condition : statId < 0");
        spellId = buf.readShort();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
        value = buf.readShort();
    }
    
}
