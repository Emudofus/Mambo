

// Generated on 12/14/2012 18:44:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeString(name);
        writer.writeDouble(mountId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        name = reader.readString();
        mountId = reader.readDouble();
    }
    
}
