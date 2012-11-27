

// Generated on 11/11/2012 20:41:27
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(registered);
        writer.writeByte(step);
        writer.writeInt(battleMode);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        registered = reader.readBoolean();
        step = reader.readByte();
        if (step < 0)
            throw new RuntimeException("Forbidden value on step = " + step + ", it doesn't respect the following condition : step < 0");
        battleMode = reader.readInt();
        if (battleMode < 0)
            throw new RuntimeException("Forbidden value on battleMode = " + battleMode + ", it doesn't respect the following condition : battleMode < 0");
    }
    
}
