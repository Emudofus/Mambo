

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeInt(actionId);
        buf.writeInt(characterId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        actionId = buf.readInt();
        if (actionId < 0)
            throw new RuntimeException("Forbidden value on actionId = " + actionId + ", it doesn't respect the following condition : actionId < 0");
        characterId = buf.readInt();
        if (characterId < 0)
            throw new RuntimeException("Forbidden value on characterId = " + characterId + ", it doesn't respect the following condition : characterId < 0");
    }
    
}
