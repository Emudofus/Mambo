

// Generated on 11/11/2012 19:17:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(characterId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        characterId = reader.readInt();
        if (characterId < 0)
            throw new RuntimeException("Forbidden value on characterId = " + characterId + ", it doesn't respect the following condition : characterId < 0");
    }
    
}
