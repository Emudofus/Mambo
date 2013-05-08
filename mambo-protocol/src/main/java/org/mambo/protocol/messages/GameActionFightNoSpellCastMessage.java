

// Generated on 05/08/2013 19:37:39
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionFightNoSpellCastMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6132;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int spellLevelId;
    
    public GameActionFightNoSpellCastMessage() { }
    
    public GameActionFightNoSpellCastMessage(int spellLevelId) {
        this.spellLevelId = spellLevelId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(spellLevelId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        spellLevelId = buf.readInt();
        if (spellLevelId < 0)
            throw new RuntimeException("Forbidden value on spellLevelId = " + spellLevelId + ", it doesn't respect the following condition : spellLevelId < 0");
    }
    
}
