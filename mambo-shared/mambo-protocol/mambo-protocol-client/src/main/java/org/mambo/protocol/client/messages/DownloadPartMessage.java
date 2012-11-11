

// Generated on 11/11/2012 20:41:38
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class DownloadPartMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1503;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String id;
    
    public DownloadPartMessage() { }
    
    public DownloadPartMessage(String id) {
        this.id = id;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(id);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readString();
    }
    
}
