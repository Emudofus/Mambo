

// Generated on 12/14/2012 18:44:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GuildHouseUpdateInformationMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6181;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public HouseInformationsForGuild housesInformations;
    
    public GuildHouseUpdateInformationMessage() { }
    
    public GuildHouseUpdateInformationMessage(HouseInformationsForGuild housesInformations) {
        this.housesInformations = housesInformations;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        housesInformations.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        housesInformations = new HouseInformationsForGuild();
        housesInformations.deserialize(reader);
    }
    
}
