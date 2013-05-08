

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GroupMonsterStaticInformationsWithAlternatives extends GroupMonsterStaticInformations {
    public static final short TYPE_ID = 396;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public AlternativeMonstersInGroupLightInformations[] alternatives;
    
    public GroupMonsterStaticInformationsWithAlternatives() { }
    
    public GroupMonsterStaticInformationsWithAlternatives(MonsterInGroupLightInformations mainCreatureLightInfos, MonsterInGroupInformations[] underlings, AlternativeMonstersInGroupLightInformations[] alternatives) {
        super(mainCreatureLightInfos, underlings);
        this.alternatives = alternatives;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUShort(alternatives.length);
        for (AlternativeMonstersInGroupLightInformations entry : alternatives) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        int limit = buf.readUShort();
        alternatives = new AlternativeMonstersInGroupLightInformations[limit];
        for (int i = 0; i < limit; i++) {
            alternatives[i] = new AlternativeMonstersInGroupLightInformations();
            alternatives[i].deserialize(buf);
        }
    }
    
}
