

// Generated on 12/14/2012 18:44:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameFightHumanReadyStateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 740;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int characterId;
    public boolean isReady;
    
    public GameFightHumanReadyStateMessage() { }
    
    public GameFightHumanReadyStateMessage(int characterId, boolean isReady) {
        this.characterId = characterId;
        this.isReady = isReady;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(characterId);
        writer.writeBoolean(isReady);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        characterId = reader.readInt();
        if (characterId < 0)
            throw new RuntimeException("Forbidden value on characterId = " + characterId + ", it doesn't respect the following condition : characterId < 0");
        isReady = reader.readBoolean();
    }
    
}
