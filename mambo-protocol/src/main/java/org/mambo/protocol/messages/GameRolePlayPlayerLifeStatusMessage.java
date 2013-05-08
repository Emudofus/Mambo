

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayPlayerLifeStatusMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5996;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte state;
    
    public GameRolePlayPlayerLifeStatusMessage() { }
    
    public GameRolePlayPlayerLifeStatusMessage(byte state) {
        this.state = state;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(state);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        state = buf.readByte();
        if (state < 0)
            throw new RuntimeException("Forbidden value on state = " + state + ", it doesn't respect the following condition : state < 0");
    }
    
}
