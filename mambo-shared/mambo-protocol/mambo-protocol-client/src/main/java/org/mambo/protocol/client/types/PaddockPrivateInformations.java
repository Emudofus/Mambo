

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import org.mambo.core.io.*;

public class PaddockPrivateInformations extends PaddockAbandonnedInformations {
    public static final short TYPE_ID = 131;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public GuildInformations guildInfo;
    
    public PaddockPrivateInformations() { }
    
    public PaddockPrivateInformations(short maxOutdoorMount, short maxItems, int price, boolean locked, int guildId, GuildInformations guildInfo) {
        super(maxOutdoorMount, maxItems, price, locked, guildId);
        this.guildInfo = guildInfo;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        guildInfo.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        guildInfo = new GuildInformations();
        guildInfo.deserialize(reader);
    }
    
}
