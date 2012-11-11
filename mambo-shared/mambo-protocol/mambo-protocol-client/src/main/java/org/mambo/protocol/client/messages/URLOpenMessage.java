

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class URLOpenMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6266;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int urlId;
    
    public URLOpenMessage() { }
    
    public URLOpenMessage(int urlId) {
        this.urlId = urlId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(urlId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        urlId = reader.readInt();
        if (urlId < 0)
            throw new RuntimeException("Forbidden value on urlId = " + urlId + ", it doesn't respect the following condition : urlId < 0");
    }
    
}
