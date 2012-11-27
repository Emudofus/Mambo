

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GuildHouseRemoveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6180;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int houseId;
    
    public GuildHouseRemoveMessage() { }
    
    public GuildHouseRemoveMessage(int houseId) {
        this.houseId = houseId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(houseId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        houseId = reader.readInt();
        if (houseId < 0)
            throw new RuntimeException("Forbidden value on houseId = " + houseId + ", it doesn't respect the following condition : houseId < 0");
    }
    
}
