

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ContactLookMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5934;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int requestId;
    public String playerName;
    public int playerId;
    public EntityLook look;
    
    public ContactLookMessage() { }
    
    public ContactLookMessage(int requestId, String playerName, int playerId, EntityLook look) {
        this.requestId = requestId;
        this.playerName = playerName;
        this.playerId = playerId;
        this.look = look;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(requestId);
        buf.writeString(playerName);
        buf.writeInt(playerId);
        look.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        requestId = buf.readInt();
        if (requestId < 0)
            throw new RuntimeException("Forbidden value on requestId = " + requestId + ", it doesn't respect the following condition : requestId < 0");
        playerName = buf.readString();
        playerId = buf.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        look = new EntityLook();
        look.deserialize(buf);
    }
    
}
