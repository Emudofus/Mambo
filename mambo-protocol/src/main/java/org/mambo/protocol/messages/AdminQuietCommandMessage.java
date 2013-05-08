

// Generated on 05/08/2013 19:37:37
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AdminQuietCommandMessage extends AdminCommandMessage {
    public static final int MESSAGE_ID = 5662;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public AdminQuietCommandMessage() { }
    
    public AdminQuietCommandMessage(String content) {
        super(content);
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
    }
    
}
