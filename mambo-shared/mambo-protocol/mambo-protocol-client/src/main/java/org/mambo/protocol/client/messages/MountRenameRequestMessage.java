

// Generated on 11/11/2012 20:41:26
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
