

// Generated on 11/11/2012 20:41:26
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class MountSetMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5968;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public MountClientData mountData;
    
    public MountSetMessage() { }
    
    public MountSetMessage(MountClientData mountData) {
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
