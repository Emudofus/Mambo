

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AchievementFinishedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6208;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short id;
    public short finishedlevel;
    
    public AchievementFinishedMessage() { }
    
    public AchievementFinishedMessage(short id, short finishedlevel) {
        this.id = id;
        this.finishedlevel = finishedlevel;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(id);
        buf.writeShort(finishedlevel);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        id = buf.readShort();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
        finishedlevel = buf.readShort();
        if (finishedlevel < 0 || finishedlevel > 200)
            throw new RuntimeException("Forbidden value on finishedlevel = " + finishedlevel + ", it doesn't respect the following condition : finishedlevel < 0 || finishedlevel > 200");
    }
    
}
