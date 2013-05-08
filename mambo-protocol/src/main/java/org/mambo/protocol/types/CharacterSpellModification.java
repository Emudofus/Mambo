

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CharacterSpellModification extends NetworkType {
    public static final short TYPE_ID = 215;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte modificationType;
    public short spellId;
    public CharacterBaseCharacteristic value;
    
    public CharacterSpellModification() { }
    
    public CharacterSpellModification(byte modificationType, short spellId, CharacterBaseCharacteristic value) {
        this.modificationType = modificationType;
        this.spellId = spellId;
        this.value = value;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(modificationType);
        buf.writeShort(spellId);
        value.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        modificationType = buf.readByte();
        if (modificationType < 0)
            throw new RuntimeException("Forbidden value on modificationType = " + modificationType + ", it doesn't respect the following condition : modificationType < 0");
        spellId = buf.readShort();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
        value = new CharacterBaseCharacteristic();
        value.deserialize(buf);
    }
    
}
