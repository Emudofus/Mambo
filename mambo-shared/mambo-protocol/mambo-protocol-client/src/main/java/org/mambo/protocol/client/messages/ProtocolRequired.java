

// Generated on 12/14/2012 18:44:18
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(requiredVersion);
        writer.writeInt(currentVersion);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        requiredVersion = reader.readInt();
        if (requiredVersion < 0)
            throw new RuntimeException("Forbidden value on requiredVersion = " + requiredVersion + ", it doesn't respect the following condition : requiredVersion < 0");
        currentVersion = reader.readInt();
        if (currentVersion < 0)
            throw new RuntimeException("Forbidden value on currentVersion = " + currentVersion + ", it doesn't respect the following condition : currentVersion < 0");
    }
    
}
