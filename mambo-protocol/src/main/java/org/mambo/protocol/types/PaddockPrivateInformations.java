

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        guildInfo.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        guildInfo = new GuildInformations();
        guildInfo.deserialize(buf);
    }
    
}
