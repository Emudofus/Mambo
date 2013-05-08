

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ChatAbstractClientMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 850;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String content;
    
    public ChatAbstractClientMessage() { }
    
    public ChatAbstractClientMessage(String content) {
        this.content = content;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(content);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        content = buf.readString();
    }
    
}
