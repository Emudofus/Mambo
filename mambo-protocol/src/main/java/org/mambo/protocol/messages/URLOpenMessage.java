

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class URLOpenMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6266;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int urlId;
    
    public URLOpenMessage() { }
    
    public URLOpenMessage(int urlId) {
        this.urlId = urlId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(urlId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        urlId = buf.readInt();
        if (urlId < 0)
            throw new RuntimeException("Forbidden value on urlId = " + urlId + ", it doesn't respect the following condition : urlId < 0");
    }
    
}
