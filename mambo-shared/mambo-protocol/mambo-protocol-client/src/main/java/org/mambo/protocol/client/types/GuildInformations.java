

// Generated on 11/11/2012 19:06:12
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GuildInformations extends BasicGuildInformations {
    public static final short TYPE_ID = 127;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public GuildEmblem guildEmblem;
    
    public GuildInformations() { }
    
    public GuildInformations(int guildId, String guildName, GuildEmblem guildEmblem) {
        super(guildId, guildName);
        this.guildEmblem = guildEmblem;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        guildEmblem.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        guildEmblem = new GuildEmblem();
        guildEmblem.deserialize(reader);
    }
    
}
