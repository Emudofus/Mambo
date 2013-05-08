

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class DownloadPartMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1503;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String id;
    
    public DownloadPartMessage() { }
    
    public DownloadPartMessage(String id) {
        this.id = id;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(id);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        id = buf.readString();
    }
    
}
