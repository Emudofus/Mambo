

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildFightTakePlaceRequestMessage extends GuildFightJoinRequestMessage {
    public static final int MESSAGE_ID = 6235;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int replacedCharacterId;
    
    public GuildFightTakePlaceRequestMessage() { }
    
    public GuildFightTakePlaceRequestMessage(int taxCollectorId, int replacedCharacterId) {
        super(taxCollectorId);
        this.replacedCharacterId = replacedCharacterId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(replacedCharacterId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        replacedCharacterId = buf.readInt();
    }
    
}
