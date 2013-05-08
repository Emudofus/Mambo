

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(housesInformations.length);
        for (HouseInformationsForGuild entry : housesInformations) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        housesInformations = new HouseInformationsForGuild[limit];
        for (int i = 0; i < limit; i++) {
            housesInformations[i] = new HouseInformationsForGuild();
            housesInformations[i].deserialize(buf);
        }
    }
    
}
