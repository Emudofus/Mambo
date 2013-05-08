

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ProtocolRequired extends NetworkMessage {
    public static final int MESSAGE_ID = 1;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int requiredVersion;
    public int currentVersion;
    
    public ProtocolRequired() { }
    
    public ProtocolRequired(int requiredVersion, int currentVersion) {
        this.requiredVersion = requiredVersion;
        this.currentVersion = currentVersion;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(requiredVersion);
        buf.writeInt(currentVersion);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        requiredVersion = buf.readInt();
        if (requiredVersion < 0)
            throw new RuntimeException("Forbidden value on requiredVersion = " + requiredVersion + ", it doesn't respect the following condition : requiredVersion < 0");
        currentVersion = buf.readInt();
        if (currentVersion < 0)
            throw new RuntimeException("Forbidden value on currentVersion = " + currentVersion + ", it doesn't respect the following condition : currentVersion < 0");
    }
    
}
