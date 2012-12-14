

// Generated on 12/14/2012 18:44:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterCapabilitiesMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6339;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int guildEmblemSymbolCategories;
    
    public CharacterCapabilitiesMessage() { }
    
    public CharacterCapabilitiesMessage(int guildEmblemSymbolCategories) {
        this.guildEmblemSymbolCategories = guildEmblemSymbolCategories;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(guildEmblemSymbolCategories);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        guildEmblemSymbolCategories = reader.readInt();
        if (guildEmblemSymbolCategories < 0)
            throw new RuntimeException("Forbidden value on guildEmblemSymbolCategories = " + guildEmblemSymbolCategories + ", it doesn't respect the following condition : guildEmblemSymbolCategories < 0");
    }
    
}
