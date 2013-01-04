

// Generated on 01/04/2013 14:54:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(id);
        writer.writeShort(finishedlevel);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readShort();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
        finishedlevel = reader.readShort();
        if (finishedlevel < 0 || finishedlevel > 200)
            throw new RuntimeException("Forbidden value on finishedlevel = " + finishedlevel + ", it doesn't respect the following condition : finishedlevel < 0 || finishedlevel > 200");
    }
    
}
