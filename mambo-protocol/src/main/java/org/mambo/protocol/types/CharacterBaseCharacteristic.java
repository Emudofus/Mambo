

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CharacterBaseCharacteristic extends NetworkType {
    public static final short TYPE_ID = 4;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeShort(base);
        buf.writeShort(objectsAndMountBonus);
        buf.writeShort(alignGiftBonus);
        buf.writeShort(contextModif);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        base = buf.readShort();
        objectsAndMountBonus = buf.readShort();
        alignGiftBonus = buf.readShort();
        contextModif = buf.readShort();
    }
    
}
