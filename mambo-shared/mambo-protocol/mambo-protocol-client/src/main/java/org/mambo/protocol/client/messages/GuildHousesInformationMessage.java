

// Generated on 12/14/2012 18:44:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GuildHousesInformationMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5919;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public HouseInformationsForGuild[] housesInformations;
    
    public GuildHousesInformationMessage() { }
    
    public GuildHousesInformationMessage(HouseInformationsForGuild[] housesInformations) {
        this.housesInformations = housesInformations;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(housesInformations.length);
        for (HouseInformationsForGuild entry : housesInformations) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        housesInformations = new HouseInformationsForGuild[limit];
        for (int i = 0; i < limit; i++) {
            housesInformations[i] = new HouseInformationsForGuild();
            housesInformations[i].deserialize(reader);
        }
    }
    
}
