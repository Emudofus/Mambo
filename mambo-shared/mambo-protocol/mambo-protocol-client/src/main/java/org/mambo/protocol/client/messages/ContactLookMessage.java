

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(requestId);
        writer.writeString(playerName);
        writer.writeInt(playerId);
        look.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        requestId = reader.readInt();
        if (requestId < 0)
            throw new RuntimeException("Forbidden value on requestId = " + requestId + ", it doesn't respect the following condition : requestId < 0");
        playerName = reader.readString();
        playerId = reader.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        look = new EntityLook();
        look.deserialize(reader);
    }
    
}
