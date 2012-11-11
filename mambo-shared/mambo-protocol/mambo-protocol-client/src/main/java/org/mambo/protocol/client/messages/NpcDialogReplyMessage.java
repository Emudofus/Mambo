

// Generated on 11/11/2012 19:17:04
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(replyId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        replyId = reader.readShort();
        if (replyId < 0)
            throw new RuntimeException("Forbidden value on replyId = " + replyId + ", it doesn't respect the following condition : replyId < 0");
    }
    
}
