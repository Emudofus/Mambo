

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameContextCreateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 200;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte context;
    
    public GameContextCreateMessage() { }
    
    public GameContextCreateMessage(byte context) {
        this.context = context;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(context);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        context = buf.readByte();
        if (context < 0)
            throw new RuntimeException("Forbidden value on context = " + context + ", it doesn't respect the following condition : context < 0");
    }
    
}
