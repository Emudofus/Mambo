

// Generated on 01/04/2013 14:54:27
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class HouseGuildRightsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5703;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short houseId;
    public GuildInformations guildInfo;
    public long rights;
    
    public HouseGuildRightsMessage() { }
    
    public HouseGuildRightsMessage(short houseId, GuildInformations guildInfo, long rights) {
        this.houseId = houseId;
        this.guildInfo = guildInfo;
        this.rights = rights;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(houseId);
        guildInfo.serialize(writer);
        writer.writeUnsignedInt(rights);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        houseId = reader.readShort();
        if (houseId < 0)
            throw new RuntimeException("Forbidden value on houseId = " + houseId + ", it doesn't respect the following condition : houseId < 0");
        guildInfo = new GuildInformations();
        guildInfo.deserialize(reader);
        rights = reader.readUnsignedInt();
        if (rights < 0 || rights > 4294967295L)
            throw new RuntimeException("Forbidden value on rights = " + rights + ", it doesn't respect the following condition : rights < 0 || rights > 4294967295L");
    }
    
}
