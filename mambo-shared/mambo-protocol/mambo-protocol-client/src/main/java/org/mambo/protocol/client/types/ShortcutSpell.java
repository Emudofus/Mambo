

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ShortcutSpell extends Shortcut {
    public static final short TYPE_ID = 368;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short spellId;
    
    public ShortcutSpell() { }
    
    public ShortcutSpell(int slot, short spellId) {
        super(slot);
        this.spellId = spellId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(spellId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        spellId = reader.readShort();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
    }
    
}
