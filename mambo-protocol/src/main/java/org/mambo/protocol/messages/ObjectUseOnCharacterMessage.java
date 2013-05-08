

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectUseOnCharacterMessage extends ObjectUseMessage {
    public static final int MESSAGE_ID = 3003;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int characterId;
    
    public ObjectUseOnCharacterMessage() { }
    
    public ObjectUseOnCharacterMessage(int objectUID, int characterId) {
        super(objectUID);
        this.characterId = characterId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(characterId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        characterId = buf.readInt();
        if (characterId < 0)
            throw new RuntimeException("Forbidden value on characterId = " + characterId + ", it doesn't respect the following condition : characterId < 0");
    }
    
}
