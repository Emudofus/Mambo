

// Generated on 01/04/2013 14:54:46
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        look.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        look = new EntityLook();
        look.deserialize(reader);
    }
    
}
