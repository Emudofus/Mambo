

// Generated on 01/04/2013 14:54:33
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GuildFightTakePlaceRequestMessage extends GuildFightJoinRequestMessage {
    public static final int MESSAGE_ID = 6235;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int replacedCharacterId;
    
    public GuildFightTakePlaceRequestMessage() { }
    
    public GuildFightTakePlaceRequestMessage(int taxCollectorId, int replacedCharacterId) {
        super(taxCollectorId);
        this.replacedCharacterId = replacedCharacterId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(replacedCharacterId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        replacedCharacterId = reader.readInt();
    }
    
}
