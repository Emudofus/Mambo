

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CharacterHardcoreInformations extends CharacterBaseInformations {
    public static final short TYPE_ID = 86;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte deathState;
    public short deathCount;
    public short deathMaxLevel;
    
    public CharacterHardcoreInformations() { }
    
    public CharacterHardcoreInformations(int id, short level, String name, EntityLook entityLook, byte breed, boolean sex, byte deathState, short deathCount, short deathMaxLevel) {
        super(id, level, name, entityLook, breed, sex);
        this.deathState = deathState;
        this.deathCount = deathCount;
        this.deathMaxLevel = deathMaxLevel;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(deathState);
        buf.writeShort(deathCount);
        buf.writeUByte(deathMaxLevel);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        deathState = buf.readByte();
        if (deathState < 0)
            throw new RuntimeException("Forbidden value on deathState = " + deathState + ", it doesn't respect the following condition : deathState < 0");
        deathCount = buf.readShort();
        if (deathCount < 0)
            throw new RuntimeException("Forbidden value on deathCount = " + deathCount + ", it doesn't respect the following condition : deathCount < 0");
        deathMaxLevel = buf.readUByte();
        if (deathMaxLevel < 1 || deathMaxLevel > 200)
            throw new RuntimeException("Forbidden value on deathMaxLevel = " + deathMaxLevel + ", it doesn't respect the following condition : deathMaxLevel < 1 || deathMaxLevel > 200");
    }
    
}
