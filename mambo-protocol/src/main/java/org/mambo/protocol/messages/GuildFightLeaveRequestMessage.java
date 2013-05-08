

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildFightLeaveRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5715;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int taxCollectorId;
    public int characterId;
    
    public GuildFightLeaveRequestMessage() { }
    
    public GuildFightLeaveRequestMessage(int taxCollectorId, int characterId) {
        this.taxCollectorId = taxCollectorId;
        this.characterId = characterId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(taxCollectorId);
        buf.writeInt(characterId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        taxCollectorId = buf.readInt();
        characterId = buf.readInt();
        if (characterId < 0)
            throw new RuntimeException("Forbidden value on characterId = " + characterId + ", it doesn't respect the following condition : characterId < 0");
    }
    
}
