

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildGetInformationsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5550;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte infoType;
    
    public GuildGetInformationsMessage() { }
    
    public GuildGetInformationsMessage(byte infoType) {
        this.infoType = infoType;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(infoType);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        infoType = buf.readByte();
        if (infoType < 0)
            throw new RuntimeException("Forbidden value on infoType = " + infoType + ", it doesn't respect the following condition : infoType < 0");
    }
    
}
