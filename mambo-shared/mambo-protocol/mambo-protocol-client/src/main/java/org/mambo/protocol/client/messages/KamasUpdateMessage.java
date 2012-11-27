

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class KamasUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5537;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int kamasTotal;
    
    public KamasUpdateMessage() { }
    
    public KamasUpdateMessage(int kamasTotal) {
        this.kamasTotal = kamasTotal;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(kamasTotal);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        kamasTotal = reader.readInt();
    }
    
}
