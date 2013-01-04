

// Generated on 01/04/2013 14:54:46
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        guildInformations.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        guildInformations = new GuildInformations();
        guildInformations.deserialize(reader);
    }
    
}
