

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class IgnoredDeleteResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5677;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean success;
    public boolean session;
    public String name;
    
    public IgnoredDeleteResultMessage() { }
    
    public IgnoredDeleteResultMessage(boolean success, boolean session, String name) {
        this.success = success;
        this.session = session;
        this.name = name;
    }
    
    @Override
    public void serialize(Buffer buf) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, success);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, session);
        buf.writeUByte(flag1);
        buf.writeString(name);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        short flag1 = buf.readUByte();
        success = BooleanByteWrapper.getFlag(flag1, 0);
        session = BooleanByteWrapper.getFlag(flag1, 1);
        name = buf.readString();
    }
    
}
