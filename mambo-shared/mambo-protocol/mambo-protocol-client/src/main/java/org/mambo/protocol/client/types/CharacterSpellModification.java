

// Generated on 12/14/2012 18:44:21
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterSpellModification implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 215;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(modificationType);
        writer.writeShort(spellId);
        value.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        modificationType = reader.readByte();
        if (modificationType < 0)
            throw new RuntimeException("Forbidden value on modificationType = " + modificationType + ", it doesn't respect the following condition : modificationType < 0");
        spellId = reader.readShort();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
        value = new CharacterBaseCharacteristic();
        value.deserialize(reader);
    }
    
}
