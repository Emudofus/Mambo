

// Generated on 01/04/2013 14:54:48
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
