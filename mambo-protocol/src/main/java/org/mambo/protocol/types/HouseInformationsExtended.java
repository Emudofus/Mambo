

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class HouseInformationsExtended extends HouseInformations {
    public static final short TYPE_ID = 112;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public GuildInformations guildInfo;
    
    public HouseInformationsExtended() { }
    
    public HouseInformationsExtended(boolean isOnSale, boolean isSaleLocked, int houseId, int[] doorsOnMap, String ownerName, short modelId, GuildInformations guildInfo) {
        super(isOnSale, isSaleLocked, houseId, doorsOnMap, ownerName, modelId);
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
