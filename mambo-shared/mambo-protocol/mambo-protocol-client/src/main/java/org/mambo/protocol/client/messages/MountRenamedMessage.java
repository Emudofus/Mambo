

// Generated on 11/11/2012 19:17:02
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeDouble(mountId);
        writer.writeString(name);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        mountId = reader.readDouble();
        name = reader.readString();
    }
    
}
