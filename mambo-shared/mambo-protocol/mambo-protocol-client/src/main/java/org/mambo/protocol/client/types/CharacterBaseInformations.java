

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(breed);
        writer.writeBoolean(sex);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        breed = reader.readByte();
        sex = reader.readBoolean();
    }
    
}
