

// Generated on 12/14/2012 18:44:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GuildSpellUpgradeRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5699;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int spellId;
    
    public GuildSpellUpgradeRequestMessage() { }
    
    public GuildSpellUpgradeRequestMessage(int spellId) {
        this.spellId = spellId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(spellId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        spellId = reader.readInt();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
    }
    
}
