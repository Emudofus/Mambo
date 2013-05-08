

// Generated on 05/08/2013 19:37:37
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AdminCommandMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 76;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String content;
    
    public AdminCommandMessage() { }
    
    public AdminCommandMessage(String content) {
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
