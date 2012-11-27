

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class HouseGuildShareRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5704;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean enable;
    public long rights;
    
    public HouseGuildShareRequestMessage() { }
    
    public HouseGuildShareRequestMessage(boolean enable, long rights) {
        this.enable = enable;
        this.rights = rights;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(enable);
        writer.writeUnsignedInt(rights);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        enable = reader.readBoolean();
        rights = reader.readUnsignedInt();
        if (rights < 0 || rights > 4294967295L)
            throw new RuntimeException("Forbidden value on rights = " + rights + ", it doesn't respect the following condition : rights < 0 || rights > 4294967295L");
    }
    
}
