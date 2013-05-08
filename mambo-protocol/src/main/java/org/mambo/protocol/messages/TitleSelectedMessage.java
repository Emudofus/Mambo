

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TitleSelectedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6366;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short titleId;
    
    public TitleSelectedMessage() { }
    
    public TitleSelectedMessage(short titleId) {
        this.titleId = titleId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(titleId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        titleId = buf.readShort();
        if (titleId < 0)
            throw new RuntimeException("Forbidden value on titleId = " + titleId + ", it doesn't respect the following condition : titleId < 0");
    }
    
}
