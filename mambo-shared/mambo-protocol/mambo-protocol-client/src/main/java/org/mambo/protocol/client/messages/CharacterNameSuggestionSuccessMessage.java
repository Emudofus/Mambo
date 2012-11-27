

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterNameSuggestionSuccessMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5544;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String suggestion;
    
    public CharacterNameSuggestionSuccessMessage() { }
    
    public CharacterNameSuggestionSuccessMessage(String suggestion) {
        this.suggestion = suggestion;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(suggestion);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        suggestion = reader.readString();
    }
    
}
