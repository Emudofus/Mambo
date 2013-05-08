

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightStartingMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 700;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte fightType;
    
    public GameFightStartingMessage() { }
    
    public GameFightStartingMessage(byte fightType) {
        this.fightType = fightType;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(fightType);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightType = buf.readByte();
        if (fightType < 0)
            throw new RuntimeException("Forbidden value on fightType = " + fightType + ", it doesn't respect the following condition : fightType < 0");
    }
    
}
