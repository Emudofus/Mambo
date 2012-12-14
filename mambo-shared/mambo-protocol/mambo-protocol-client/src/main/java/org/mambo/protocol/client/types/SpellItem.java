

// Generated on 12/14/2012 18:44:22
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedByte(position);
        writer.writeInt(spellId);
        writer.writeByte(spellLevel);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        position = reader.readUnsignedByte();
        if (position < 63 || position > 255)
            throw new RuntimeException("Forbidden value on position = " + position + ", it doesn't respect the following condition : position < 63 || position > 255");
        spellId = reader.readInt();
        spellLevel = reader.readByte();
        if (spellLevel < 1 || spellLevel > 6)
            throw new RuntimeException("Forbidden value on spellLevel = " + spellLevel + ", it doesn't respect the following condition : spellLevel < 1 || spellLevel > 6");
    }
    
}
