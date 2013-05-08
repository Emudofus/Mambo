

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MountRenamedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5983;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double mountId;
    public String name;
    
    public MountRenamedMessage() { }
    
    public MountRenamedMessage(double mountId, String name) {
        this.mountId = mountId;
        this.name = name;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeDouble(mountId);
        buf.writeString(name);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        mountId = buf.readDouble();
        name = buf.readString();
    }
    
}
