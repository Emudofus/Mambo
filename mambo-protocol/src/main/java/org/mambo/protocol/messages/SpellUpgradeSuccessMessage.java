

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SpellUpgradeSuccessMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1201;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int spellId;
    public byte spellLevel;
    
    public SpellUpgradeSuccessMessage() { }
    
    public SpellUpgradeSuccessMessage(int spellId, byte spellLevel) {
        this.spellId = spellId;
        this.spellLevel = spellLevel;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(spellId);
        buf.writeByte(spellLevel);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        spellId = buf.readInt();
        spellLevel = buf.readByte();
        if (spellLevel < 1 || spellLevel > 6)
            throw new RuntimeException("Forbidden value on spellLevel = " + spellLevel + ", it doesn't respect the following condition : spellLevel < 1 || spellLevel > 6");
    }
    
}
