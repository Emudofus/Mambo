

// Generated on 01/04/2013 14:54:32
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GuildHouseTeleportRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5712;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int houseId;
    
    public GuildHouseTeleportRequestMessage() { }
    
    public GuildHouseTeleportRequestMessage(int houseId) {
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
