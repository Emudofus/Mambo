

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class CharacterBaseCharacteristic implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 4;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short base;
    public short objectsAndMountBonus;
    public short alignGiftBonus;
    public short contextModif;
    
    public CharacterBaseCharacteristic() { }
    
    public CharacterBaseCharacteristic(short base, short objectsAndMountBonus, short alignGiftBonus, short contextModif) {
        this.base = base;
        this.objectsAndMountBonus = objectsAndMountBonus;
        this.alignGiftBonus = alignGiftBonus;
        this.contextModif = contextModif;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(base);
        writer.writeShort(objectsAndMountBonus);
        writer.writeShort(alignGiftBonus);
        writer.writeShort(contextModif);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        base = reader.readShort();
        objectsAndMountBonus = reader.readShort();
        alignGiftBonus = reader.readShort();
        contextModif = reader.readShort();
    }
    
}
