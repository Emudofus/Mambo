

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class HumanOptionGuild extends HumanOption {
    public static final short TYPE_ID = 409;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public GuildInformations guildInformations;
    
    public HumanOptionGuild() { }
    
    public HumanOptionGuild(GuildInformations guildInformations) {
        this.guildInformations = guildInformations;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        guildInformations.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        guildInformations = new GuildInformations();
        guildInformations.deserialize(buf);
    }
    
}
