

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class LocalizedChatSmileyMessage extends ChatSmileyMessage {
    public static final int MESSAGE_ID = 6185;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short cellId;
    
    public LocalizedChatSmileyMessage() { }
    
    public LocalizedChatSmileyMessage(int entityId, byte smileyId, int accountId, short cellId) {
        super(entityId, smileyId, accountId);
        this.cellId = cellId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(cellId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        cellId = buf.readShort();
        if (cellId < 0 || cellId > 559)
            throw new RuntimeException("Forbidden value on cellId = " + cellId + ", it doesn't respect the following condition : cellId < 0 || cellId > 559");
    }
    
}
