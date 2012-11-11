

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PaddockAbandonnedInformations extends PaddockBuyableInformations {
    public static final short TYPE_ID = 133;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int guildId;
    
    public PaddockAbandonnedInformations() { }
    
    public PaddockAbandonnedInformations(short maxOutdoorMount, short maxItems, int price, boolean locked, int guildId) {
        super(maxOutdoorMount, maxItems, price, locked);
        this.guildId = guildId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(guildId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        guildId = reader.readInt();
    }
    
}
