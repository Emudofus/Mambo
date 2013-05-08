

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildSpellUpgradeRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5699;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int spellId;
    
    public GuildSpellUpgradeRequestMessage() { }
    
    public GuildSpellUpgradeRequestMessage(int spellId) {
        this.spellId = spellId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(spellId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        spellId = buf.readInt();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
    }
    
}
