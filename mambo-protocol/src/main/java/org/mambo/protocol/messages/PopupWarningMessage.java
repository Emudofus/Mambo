

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeUByte(lockDuration);
        buf.writeString(author);
        buf.writeString(content);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        lockDuration = buf.readUByte();
        if (lockDuration < 0 || lockDuration > 255)
            throw new RuntimeException("Forbidden value on lockDuration = " + lockDuration + ", it doesn't respect the following condition : lockDuration < 0 || lockDuration > 255");
        author = buf.readString();
        content = buf.readString();
    }
    
}
