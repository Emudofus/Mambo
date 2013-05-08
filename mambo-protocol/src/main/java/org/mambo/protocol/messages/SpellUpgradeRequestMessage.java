

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SpellUpgradeRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5608;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short spellId;
    public byte spellLevel;
    
    public SpellUpgradeRequestMessage() { }
    
    public SpellUpgradeRequestMessage(short spellId, byte spellLevel) {
        this.spellId = spellId;
        this.spellLevel = spellLevel;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(spellId);
        buf.writeByte(spellLevel);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        spellId = buf.readShort();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
        spellLevel = buf.readByte();
        if (spellLevel < 1 || spellLevel > 6)
            throw new RuntimeException("Forbidden value on spellLevel = " + spellLevel + ", it doesn't respect the following condition : spellLevel < 1 || spellLevel > 6");
    }
    
}
