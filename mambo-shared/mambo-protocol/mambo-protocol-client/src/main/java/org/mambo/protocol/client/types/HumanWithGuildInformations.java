

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import org.mambo.core.io.*;

public class HumanWithGuildInformations extends HumanInformations {
    public static final short TYPE_ID = 153;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public GuildInformations guildInformations;
    
    public HumanWithGuildInformations() { }
    
    public HumanWithGuildInformations(EntityLook[] followingCharactersLook, byte emoteId, double emoteStartTime, ActorRestrictionsInformations restrictions, short titleId, String titleParam, GuildInformations guildInformations) {
        super(followingCharactersLook, emoteId, emoteStartTime, restrictions, titleId, titleParam);
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
