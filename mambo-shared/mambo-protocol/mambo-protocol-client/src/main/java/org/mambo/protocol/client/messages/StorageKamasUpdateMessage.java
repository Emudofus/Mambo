

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class StorageKamasUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5645;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int kamasTotal;
    
    public StorageKamasUpdateMessage() { }
    
    public StorageKamasUpdateMessage(int kamasTotal) {
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
