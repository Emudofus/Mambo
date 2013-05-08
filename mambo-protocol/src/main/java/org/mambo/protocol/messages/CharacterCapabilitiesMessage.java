

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeInt(guildEmblemSymbolCategories);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        guildEmblemSymbolCategories = buf.readInt();
        if (guildEmblemSymbolCategories < 0)
            throw new RuntimeException("Forbidden value on guildEmblemSymbolCategories = " + guildEmblemSymbolCategories + ", it doesn't respect the following condition : guildEmblemSymbolCategories < 0");
    }
    
}
