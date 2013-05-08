

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayArenaRegisterMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6280;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int battleMode;
    
    public GameRolePlayArenaRegisterMessage() { }
    
    public GameRolePlayArenaRegisterMessage(int battleMode) {
        this.battleMode = battleMode;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(battleMode);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        battleMode = buf.readInt();
        if (battleMode < 0)
            throw new RuntimeException("Forbidden value on battleMode = " + battleMode + ", it doesn't respect the following condition : battleMode < 0");
    }
    
}
