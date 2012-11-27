

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AtlasPointInformationsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5956;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public AtlasPointsInformations type;
    
    public AtlasPointInformationsMessage() { }
    
    public AtlasPointInformationsMessage(AtlasPointsInformations type) {
        this.type = type;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        type.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        type = new AtlasPointsInformations();
        type.deserialize(reader);
    }
    
}
