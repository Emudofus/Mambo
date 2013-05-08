

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayArenaRegistrationStatusMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6284;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean registered;
    public byte step;
    public int battleMode;
    
    public GameRolePlayArenaRegistrationStatusMessage() { }
    
    public GameRolePlayArenaRegistrationStatusMessage(boolean registered, byte step, int battleMode) {
        this.registered = registered;
        this.step = step;
        this.battleMode = battleMode;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(registered);
        buf.writeByte(step);
        buf.writeInt(battleMode);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        registered = buf.readBoolean();
        step = buf.readByte();
        if (step < 0)
            throw new RuntimeException("Forbidden value on step = " + step + ", it doesn't respect the following condition : step < 0");
        battleMode = buf.readInt();
        if (battleMode < 0)
            throw new RuntimeException("Forbidden value on battleMode = " + battleMode + ", it doesn't respect the following condition : battleMode < 0");
    }
    
}
