

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class SpellListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1200;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean spellPrevisualization;
    public SpellItem[] spells;
    
    public SpellListMessage() { }
    
    public SpellListMessage(boolean spellPrevisualization, SpellItem[] spells) {
        this.spellPrevisualization = spellPrevisualization;
        this.spells = spells;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(spellPrevisualization);
        writer.writeUnsignedShort(spells.length);
        for (SpellItem entry : spells) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        spellPrevisualization = reader.readBoolean();
        int limit = reader.readUnsignedShort();
        spells = new SpellItem[limit];
        for (int i = 0; i < limit; i++) {
            spells[i] = new SpellItem();
            spells[i].deserialize(reader);
        }
    }
    
}
