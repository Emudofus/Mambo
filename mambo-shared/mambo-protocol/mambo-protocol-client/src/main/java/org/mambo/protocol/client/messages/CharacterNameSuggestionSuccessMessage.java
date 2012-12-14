

// Generated on 12/14/2012 18:44:04
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
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
