

// Generated on 12/14/2012 18:44:22
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class HumanWithGuildInformations extends HumanInformations {
    public static final short TYPE_ID = 153;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public GuildInformations guildInformations;
    
    public HumanWithGuildInformations() { }
    
    public HumanWithGuildInformations(ActorRestrictionsInformations restrictions, boolean sex, HumanOption[] options, GuildInformations guildInformations) {
        super(restrictions, sex, options);
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
