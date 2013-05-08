

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ValidateSpellForgetMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1700;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short spellId;
    
    public ValidateSpellForgetMessage() { }
    
    public ValidateSpellForgetMessage(short spellId) {
        this.spellId = spellId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(spellId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        spellId = buf.readShort();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
    }
    
}
