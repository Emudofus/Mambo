

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class JobCrafterDirectoryEntryRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6043;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int playerId;
    
    public JobCrafterDirectoryEntryRequestMessage() { }
    
    public JobCrafterDirectoryEntryRequestMessage(int playerId) {
        this.playerId = playerId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(playerId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        playerId = buf.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
    }
    
}
