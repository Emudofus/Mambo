

// Generated on 05/08/2013 19:37:41
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeString(suggestion);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        suggestion = buf.readString();
    }
    
}
