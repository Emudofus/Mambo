

// Generated on 01/04/2013 14:54:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class FriendGuildWarnOnAchievementCompleteStateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6383;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean enable;
    
    public FriendGuildWarnOnAchievementCompleteStateMessage() { }
    
    public FriendGuildWarnOnAchievementCompleteStateMessage(boolean enable) {
        this.enable = enable;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(enable);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        enable = reader.readBoolean();
    }
    
}
