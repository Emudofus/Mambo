

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterNameSuggestionFailureMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 164;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte reason;
    
    public CharacterNameSuggestionFailureMessage() { }
    
    public CharacterNameSuggestionFailureMessage(byte reason) {
        this.reason = reason;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(reason);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        reason = reader.readByte();
        if (reason < 0)
            throw new RuntimeException("Forbidden value on reason = " + reason + ", it doesn't respect the following condition : reason < 0");
    }
    
}
