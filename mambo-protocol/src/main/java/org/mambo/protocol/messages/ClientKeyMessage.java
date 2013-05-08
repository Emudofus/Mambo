

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ClientKeyMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5607;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String key;
    
    public ClientKeyMessage() { }
    
    public ClientKeyMessage(String key) {
        this.key = key;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(key);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        key = buf.readString();
    }
    
}
