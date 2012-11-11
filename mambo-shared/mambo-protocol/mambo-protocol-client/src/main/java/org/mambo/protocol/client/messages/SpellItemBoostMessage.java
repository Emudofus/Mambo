

// Generated on 11/11/2012 19:17:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class SpellItemBoostMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6011;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int statId;
    public short spellId;
    public short value;
    
    public SpellItemBoostMessage() { }
    
    public SpellItemBoostMessage(int statId, short spellId, short value) {
        this.statId = statId;
        this.spellId = spellId;
        this.value = value;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(statId);
        writer.writeShort(spellId);
        writer.writeShort(value);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        statId = reader.readInt();
        if (statId < 0)
            throw new RuntimeException("Forbidden value on statId = " + statId + ", it doesn't respect the following condition : statId < 0");
        spellId = reader.readShort();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
        value = reader.readShort();
    }
    
}
