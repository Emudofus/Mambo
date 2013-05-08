

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildUIOpenedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5561;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte type;
    
    public GuildUIOpenedMessage() { }
    
    public GuildUIOpenedMessage(byte type) {
        this.type = type;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(type);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        type = buf.readByte();
        if (type < 0)
            throw new RuntimeException("Forbidden value on type = " + type + ", it doesn't respect the following condition : type < 0");
    }
    
}
