

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MonsterInGroupInformations extends MonsterInGroupLightInformations {
    public static final short TYPE_ID = 144;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public EntityLook look;
    
    public MonsterInGroupInformations() { }
    
    public MonsterInGroupInformations(int creatureGenericId, byte grade, EntityLook look) {
        super(creatureGenericId, grade);
        this.look = look;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        look.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        look = new EntityLook();
        look.deserialize(buf);
    }
    
}
