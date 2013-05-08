

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        housesInformations.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        housesInformations = new HouseInformationsForGuild();
        housesInformations.deserialize(buf);
    }
    
}
