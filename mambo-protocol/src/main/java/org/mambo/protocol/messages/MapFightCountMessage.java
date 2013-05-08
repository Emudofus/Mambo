

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MapFightCountMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 210;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short fightCount;
    
    public MapFightCountMessage() { }
    
    public MapFightCountMessage(short fightCount) {
        this.fightCount = fightCount;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(fightCount);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightCount = buf.readShort();
        if (fightCount < 0)
            throw new RuntimeException("Forbidden value on fightCount = " + fightCount + ", it doesn't respect the following condition : fightCount < 0");
    }
    
}
