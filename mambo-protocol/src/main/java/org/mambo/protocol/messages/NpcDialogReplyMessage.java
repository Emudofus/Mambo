

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class NpcDialogReplyMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5616;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short replyId;
    
    public NpcDialogReplyMessage() { }
    
    public NpcDialogReplyMessage(short replyId) {
        this.replyId = replyId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(replyId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        replyId = buf.readShort();
        if (replyId < 0)
            throw new RuntimeException("Forbidden value on replyId = " + replyId + ", it doesn't respect the following condition : replyId < 0");
    }
    
}
