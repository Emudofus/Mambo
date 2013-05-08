

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        entityLook.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        entityLook = new EntityLook();
        entityLook.deserialize(buf);
    }
    
}
