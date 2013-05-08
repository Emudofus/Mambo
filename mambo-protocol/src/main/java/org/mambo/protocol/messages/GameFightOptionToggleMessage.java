

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightOptionToggleMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 707;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte option;
    
    public GameFightOptionToggleMessage() { }
    
    public GameFightOptionToggleMessage(byte option) {
        this.option = option;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(option);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        option = buf.readByte();
        if (option < 0)
            throw new RuntimeException("Forbidden value on option = " + option + ", it doesn't respect the following condition : option < 0");
    }
    
}
