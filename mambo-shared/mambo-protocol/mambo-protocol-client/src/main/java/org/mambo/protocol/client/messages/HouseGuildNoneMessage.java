

// Generated on 12/14/2012 18:44:08
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class HouseGuildNoneMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5701;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short houseId;
    
    public HouseGuildNoneMessage() { }
    
    public HouseGuildNoneMessage(short houseId) {
        this.houseId = houseId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(houseId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        houseId = reader.readShort();
        if (houseId < 0)
            throw new RuntimeException("Forbidden value on houseId = " + houseId + ", it doesn't respect the following condition : houseId < 0");
    }
    
}
