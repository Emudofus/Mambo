

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(deathState);
        writer.writeShort(deathCount);
        writer.writeUnsignedByte(deathMaxLevel);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        deathState = reader.readByte();
        if (deathState < 0)
            throw new RuntimeException("Forbidden value on deathState = " + deathState + ", it doesn't respect the following condition : deathState < 0");
        deathCount = reader.readShort();
        if (deathCount < 0)
            throw new RuntimeException("Forbidden value on deathCount = " + deathCount + ", it doesn't respect the following condition : deathCount < 0");
        deathMaxLevel = reader.readUnsignedByte();
        if (deathMaxLevel < 1 || deathMaxLevel > 200)
            throw new RuntimeException("Forbidden value on deathMaxLevel = " + deathMaxLevel + ", it doesn't respect the following condition : deathMaxLevel < 1 || deathMaxLevel > 200");
    }
    
}
