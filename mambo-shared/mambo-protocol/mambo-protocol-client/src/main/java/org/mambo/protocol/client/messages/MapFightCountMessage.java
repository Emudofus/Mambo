

// Generated on 11/11/2012 20:41:27
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(fightCount);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightCount = reader.readShort();
        if (fightCount < 0)
            throw new RuntimeException("Forbidden value on fightCount = " + fightCount + ", it doesn't respect the following condition : fightCount < 0");
    }
    
}
