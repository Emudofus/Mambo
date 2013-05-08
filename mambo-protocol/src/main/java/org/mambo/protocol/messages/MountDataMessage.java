

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MountDataMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5973;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public MountClientData mountData;
    
    public MountDataMessage() { }
    
    public MountDataMessage(MountClientData mountData) {
        this.mountData = mountData;
    }
    
    @Override
    public void serialize(Buffer buf) {
        mountData.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        mountData = new MountClientData();
        mountData.deserialize(buf);
    }
    
}
