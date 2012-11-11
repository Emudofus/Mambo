

// Generated on 11/11/2012 19:17:04
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(messageId);
        writer.writeUnsignedShort(dialogParams.length);
        for (String entry : dialogParams) {
            writer.writeString(entry);
        }
        writer.writeUnsignedShort(visibleReplies.length);
        for (short entry : visibleReplies) {
            writer.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        messageId = reader.readShort();
        if (messageId < 0)
            throw new RuntimeException("Forbidden value on messageId = " + messageId + ", it doesn't respect the following condition : messageId < 0");
        int limit = reader.readUnsignedShort();
        dialogParams = new String[limit];
        for (int i = 0; i < limit; i++) {
            dialogParams[i] = reader.readString();
        }
        limit = reader.readUnsignedShort();
        visibleReplies = new short[limit];
        for (int i = 0; i < limit; i++) {
            visibleReplies[i] = reader.readShort();
        }
    }
    
}
