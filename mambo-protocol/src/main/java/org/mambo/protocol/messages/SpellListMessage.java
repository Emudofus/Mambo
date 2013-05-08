

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeBoolean(spellPrevisualization);
        buf.writeUShort(spells.length);
        for (SpellItem entry : spells) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        spellPrevisualization = buf.readBoolean();
        int limit = buf.readUShort();
        spells = new SpellItem[limit];
        for (int i = 0; i < limit; i++) {
            spells[i] = new SpellItem();
            spells[i].deserialize(buf);
        }
    }
    
}
