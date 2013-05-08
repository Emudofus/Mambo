

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeShort(houseId);
        guildInfo.serialize(buf);
        buf.writeUInt(rights);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        houseId = buf.readShort();
        if (houseId < 0)
            throw new RuntimeException("Forbidden value on houseId = " + houseId + ", it doesn't respect the following condition : houseId < 0");
        guildInfo = new GuildInformations();
        guildInfo.deserialize(buf);
        rights = buf.readUInt();
        if (rights < 0 || rights > 4294967295L)
            throw new RuntimeException("Forbidden value on rights = " + rights + ", it doesn't respect the following condition : rights < 0 || rights > 4294967295L");
    }
    
}
