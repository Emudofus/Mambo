

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CharacterLevelUpMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5670;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short newLevel;
    
    public CharacterLevelUpMessage() { }
    
    public CharacterLevelUpMessage(short newLevel) {
        this.newLevel = newLevel;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUByte(newLevel);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        newLevel = buf.readUByte();
        if (newLevel < 2 || newLevel > 200)
            throw new RuntimeException("Forbidden value on newLevel = " + newLevel + ", it doesn't respect the following condition : newLevel < 2 || newLevel > 200");
    }
    
}
