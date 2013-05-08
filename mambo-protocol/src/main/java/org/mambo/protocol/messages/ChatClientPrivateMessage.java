

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ChatClientPrivateMessage extends ChatAbstractClientMessage {
    public static final int MESSAGE_ID = 851;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String receiver;
    
    public ChatClientPrivateMessage() { }
    
    public ChatClientPrivateMessage(String content, String receiver) {
        super(content);
        this.receiver = receiver;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeString(receiver);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        receiver = buf.readString();
    }
    
}
