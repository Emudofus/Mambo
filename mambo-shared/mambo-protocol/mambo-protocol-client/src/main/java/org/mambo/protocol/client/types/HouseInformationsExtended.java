

// Generated on 11/11/2012 19:06:14
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
