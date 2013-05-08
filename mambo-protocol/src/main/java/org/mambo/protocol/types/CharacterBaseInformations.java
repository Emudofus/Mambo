

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CharacterBaseInformations extends CharacterMinimalPlusLookInformations {
    public static final short TYPE_ID = 45;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte breed;
    public boolean sex;
    
    public CharacterBaseInformations() { }
    
    public CharacterBaseInformations(int id, short level, String name, EntityLook entityLook, byte breed, boolean sex) {
        super(id, level, name, entityLook);
        this.breed = breed;
        this.sex = sex;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(breed);
        buf.writeBoolean(sex);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        breed = buf.readByte();
        sex = buf.readBoolean();
    }
    
}
