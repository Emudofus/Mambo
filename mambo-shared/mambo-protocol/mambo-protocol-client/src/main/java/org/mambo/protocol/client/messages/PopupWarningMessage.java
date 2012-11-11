

// Generated on 11/11/2012 19:17:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PopupWarningMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6134;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short lockDuration;
    public String author;
    public String content;
    
    public PopupWarningMessage() { }
    
    public PopupWarningMessage(short lockDuration, String author, String content) {
        this.lockDuration = lockDuration;
        this.author = author;
        this.content = content;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedByte(lockDuration);
        writer.writeString(author);
        writer.writeString(content);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        lockDuration = reader.readUnsignedByte();
        if (lockDuration < 0 || lockDuration > 255)
            throw new RuntimeException("Forbidden value on lockDuration = " + lockDuration + ", it doesn't respect the following condition : lockDuration < 0 || lockDuration > 255");
        author = reader.readString();
        content = reader.readString();
    }
    
}
