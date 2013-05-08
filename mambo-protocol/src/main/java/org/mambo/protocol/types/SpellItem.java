

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SpellItem extends Item {
    public static final short TYPE_ID = 49;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short position;
    public int spellId;
    public byte spellLevel;
    
    public SpellItem() { }
    
    public SpellItem(short position, int spellId, byte spellLevel) {
        this.position = position;
        this.spellId = spellId;
        this.spellLevel = spellLevel;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUByte(position);
        buf.writeInt(spellId);
        buf.writeByte(spellLevel);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        position = buf.readUByte();
        if (position < 63 || position > 255)
            throw new RuntimeException("Forbidden value on position = " + position + ", it doesn't respect the following condition : position < 63 || position > 255");
        spellId = buf.readInt();
        spellLevel = buf.readByte();
        if (spellLevel < 1 || spellLevel > 6)
            throw new RuntimeException("Forbidden value on spellLevel = " + spellLevel + ", it doesn't respect the following condition : spellLevel < 1 || spellLevel > 6");
    }
    
}
