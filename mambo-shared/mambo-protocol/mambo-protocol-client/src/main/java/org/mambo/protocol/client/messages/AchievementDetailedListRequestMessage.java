

// Generated on 01/04/2013 14:54:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AchievementDetailedListRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6357;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short categoryId;
    
    public AchievementDetailedListRequestMessage() { }
    
    public AchievementDetailedListRequestMessage(short categoryId) {
        this.categoryId = categoryId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(categoryId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        categoryId = reader.readShort();
        if (categoryId < 0)
            throw new RuntimeException("Forbidden value on categoryId = " + categoryId + ", it doesn't respect the following condition : categoryId < 0");
    }
    
}
