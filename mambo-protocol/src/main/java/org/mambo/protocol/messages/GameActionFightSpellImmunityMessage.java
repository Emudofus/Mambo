

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionFightSpellImmunityMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 6221;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public int spellId;
    
    public GameActionFightSpellImmunityMessage() { }
    
    public GameActionFightSpellImmunityMessage(short actionId, int sourceId, int targetId, int spellId) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.spellId = spellId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(targetId);
        buf.writeInt(spellId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        targetId = buf.readInt();
        spellId = buf.readInt();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
    }
    
}
