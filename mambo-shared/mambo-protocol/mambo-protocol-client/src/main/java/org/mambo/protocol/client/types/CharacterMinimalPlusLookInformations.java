

// Generated on 12/14/2012 18:44:21
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterMinimalPlusLookInformations extends CharacterMinimalInformations {
    public static final short TYPE_ID = 163;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public EntityLook entityLook;
    
    public CharacterMinimalPlusLookInformations() { }
    
    public CharacterMinimalPlusLookInformations(int id, short level, String name, EntityLook entityLook) {
        super(id, level, name);
        this.entityLook = entityLook;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        entityLook.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        entityLook = new EntityLook();
        entityLook.deserialize(reader);
    }
    
}
