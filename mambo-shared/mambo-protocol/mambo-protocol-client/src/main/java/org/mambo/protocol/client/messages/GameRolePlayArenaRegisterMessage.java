

// Generated on 01/04/2013 14:54:26
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(battleMode);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        battleMode = reader.readInt();
        if (battleMode < 0)
            throw new RuntimeException("Forbidden value on battleMode = " + battleMode + ", it doesn't respect the following condition : battleMode < 0");
    }
    
}
