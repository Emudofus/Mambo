

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(spellId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        spellId = buf.readShort();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
    }
    
}
