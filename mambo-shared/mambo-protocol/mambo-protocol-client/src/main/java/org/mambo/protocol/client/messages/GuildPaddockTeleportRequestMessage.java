

// Generated on 01/04/2013 14:54:33
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GuildPaddockTeleportRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5957;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int paddockId;
    
    public GuildPaddockTeleportRequestMessage() { }
    
    public GuildPaddockTeleportRequestMessage(int paddockId) {
        this.paddockId = paddockId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(paddockId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        paddockId = reader.readInt();
    }
    
}
