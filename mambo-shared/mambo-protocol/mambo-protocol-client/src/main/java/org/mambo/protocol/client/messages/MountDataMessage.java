

// Generated on 01/04/2013 14:54:24
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        mountData.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        mountData = new MountClientData();
        mountData.deserialize(reader);
    }
    
}
