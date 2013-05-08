

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class NpcDialogQuestionMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5617;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short messageId;
    public String[] dialogParams;
    public short[] visibleReplies;
    
    public NpcDialogQuestionMessage() { }
    
    public NpcDialogQuestionMessage(short messageId, String[] dialogParams, short[] visibleReplies) {
        this.messageId = messageId;
        this.dialogParams = dialogParams;
        this.visibleReplies = visibleReplies;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(messageId);
        buf.writeUShort(dialogParams.length);
        for (String entry : dialogParams) {
            buf.writeString(entry);
        }
        buf.writeUShort(visibleReplies.length);
        for (short entry : visibleReplies) {
            buf.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        messageId = buf.readShort();
        if (messageId < 0)
            throw new RuntimeException("Forbidden value on messageId = " + messageId + ", it doesn't respect the following condition : messageId < 0");
        int limit = buf.readUShort();
        dialogParams = new String[limit];
        for (int i = 0; i < limit; i++) {
            dialogParams[i] = buf.readString();
        }
        limit = buf.readUShort();
        visibleReplies = new short[limit];
        for (int i = 0; i < limit; i++) {
            visibleReplies[i] = buf.readShort();
        }
    }
    
}
