

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterDeletionRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 165;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int characterId;
    public String secretAnswerHash;
    
    public CharacterDeletionRequestMessage() { }
    
    public CharacterDeletionRequestMessage(int characterId, String secretAnswerHash) {
        this.characterId = characterId;
        this.secretAnswerHash = secretAnswerHash;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(characterId);
        writer.writeString(secretAnswerHash);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        characterId = reader.readInt();
        if (characterId < 0)
            throw new RuntimeException("Forbidden value on characterId = " + characterId + ", it doesn't respect the following condition : characterId < 0");
        secretAnswerHash = reader.readString();
    }
    
}
