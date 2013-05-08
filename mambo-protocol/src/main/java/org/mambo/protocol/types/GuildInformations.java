

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        guildEmblem.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        guildEmblem = new GuildEmblem();
        guildEmblem.deserialize(buf);
    }
    
}
