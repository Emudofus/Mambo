

// Generated on 11/11/2012 19:17:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class StartupActionsObjetAttributionMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1303;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int actionId;
    public int characterId;
    
    public StartupActionsObjetAttributionMessage() { }
    
    public StartupActionsObjetAttributionMessage(int actionId, int characterId) {
        this.actionId = actionId;
        this.characterId = characterId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(actionId);
        writer.writeInt(characterId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        actionId = reader.readInt();
        if (actionId < 0)
            throw new RuntimeException("Forbidden value on actionId = " + actionId + ", it doesn't respect the following condition : actionId < 0");
        characterId = reader.readInt();
        if (characterId < 0)
            throw new RuntimeException("Forbidden value on characterId = " + characterId + ", it doesn't respect the following condition : characterId < 0");
    }
    
}
