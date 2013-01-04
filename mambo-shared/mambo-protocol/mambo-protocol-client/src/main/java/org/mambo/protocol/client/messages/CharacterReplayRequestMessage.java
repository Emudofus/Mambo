

// Generated on 01/04/2013 14:54:21
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterReplayRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 167;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int characterId;
    
    public CharacterReplayRequestMessage() { }
    
    public CharacterReplayRequestMessage(int characterId) {
        this.characterId = characterId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(characterId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        characterId = reader.readInt();
        if (characterId < 0)
            throw new RuntimeException("Forbidden value on characterId = " + characterId + ", it doesn't respect the following condition : characterId < 0");
    }
    
}
