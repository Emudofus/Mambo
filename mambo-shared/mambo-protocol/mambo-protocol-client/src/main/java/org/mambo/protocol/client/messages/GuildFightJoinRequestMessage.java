

// Generated on 01/04/2013 14:54:33
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GuildFightJoinRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5717;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int taxCollectorId;
    
    public GuildFightJoinRequestMessage() { }
    
    public GuildFightJoinRequestMessage(int taxCollectorId) {
        this.taxCollectorId = taxCollectorId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(taxCollectorId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        taxCollectorId = reader.readInt();
    }
    
}
