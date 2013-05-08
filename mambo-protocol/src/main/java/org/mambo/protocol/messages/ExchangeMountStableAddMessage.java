

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeMountStableAddMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5971;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public MountClientData mountDescription;
    
    public ExchangeMountStableAddMessage() { }
    
    public ExchangeMountStableAddMessage(MountClientData mountDescription) {
        this.mountDescription = mountDescription;
    }
    
    @Override
    public void serialize(Buffer buf) {
        mountDescription.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        mountDescription = new MountClientData();
        mountDescription.deserialize(buf);
    }
    
}
