

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class LifePointsRegenBeginMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5684;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short regenRate;
    
    public LifePointsRegenBeginMessage() { }
    
    public LifePointsRegenBeginMessage(short regenRate) {
        this.regenRate = regenRate;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUByte(regenRate);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        regenRate = buf.readUByte();
        if (regenRate < 0 || regenRate > 255)
            throw new RuntimeException("Forbidden value on regenRate = " + regenRate + ", it doesn't respect the following condition : regenRate < 0 || regenRate > 255");
    }
    
}
