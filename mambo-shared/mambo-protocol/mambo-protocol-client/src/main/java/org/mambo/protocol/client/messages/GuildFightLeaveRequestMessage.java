

// Generated on 12/14/2012 18:44:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GuildFightLeaveRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5715;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int taxCollectorId;
    public int characterId;
    
    public GuildFightLeaveRequestMessage() { }
    
    public GuildFightLeaveRequestMessage(int taxCollectorId, int characterId) {
        this.taxCollectorId = taxCollectorId;
        this.characterId = characterId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(taxCollectorId);
        writer.writeInt(characterId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        taxCollectorId = reader.readInt();
        characterId = reader.readInt();
        if (characterId < 0)
            throw new RuntimeException("Forbidden value on characterId = " + characterId + ", it doesn't respect the following condition : characterId < 0");
    }
    
}
