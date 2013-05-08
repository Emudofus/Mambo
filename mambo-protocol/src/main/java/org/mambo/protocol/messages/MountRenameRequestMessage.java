

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MountRenameRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5987;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String name;
    public double mountId;
    
    public MountRenameRequestMessage() { }
    
    public MountRenameRequestMessage(String name, double mountId) {
        this.name = name;
        this.mountId = mountId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(name);
        buf.writeDouble(mountId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        name = buf.readString();
        mountId = buf.readDouble();
    }
    
}
