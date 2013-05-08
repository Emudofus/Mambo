

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeShort(categoryId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        categoryId = buf.readShort();
        if (categoryId < 0)
            throw new RuntimeException("Forbidden value on categoryId = " + categoryId + ", it doesn't respect the following condition : categoryId < 0");
    }
    
}
