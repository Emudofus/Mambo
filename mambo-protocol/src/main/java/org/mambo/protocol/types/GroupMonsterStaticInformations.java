

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GroupMonsterStaticInformations extends NetworkType {
    public static final short TYPE_ID = 140;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public MonsterInGroupLightInformations mainCreatureLightInfos;
    public MonsterInGroupInformations[] underlings;
    
    public GroupMonsterStaticInformations() { }
    
    public GroupMonsterStaticInformations(MonsterInGroupLightInformations mainCreatureLightInfos, MonsterInGroupInformations[] underlings) {
        this.mainCreatureLightInfos = mainCreatureLightInfos;
        this.underlings = underlings;
    }
    
    @Override
    public void serialize(Buffer buf) {
        mainCreatureLightInfos.serialize(buf);
        buf.writeUShort(underlings.length);
        for (MonsterInGroupInformations entry : underlings) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        mainCreatureLightInfos = new MonsterInGroupLightInformations();
        mainCreatureLightInfos.deserialize(buf);
        int limit = buf.readUShort();
        underlings = new MonsterInGroupInformations[limit];
        for (int i = 0; i < limit; i++) {
            underlings[i] = new MonsterInGroupInformations();
            underlings[i].deserialize(buf);
        }
    }
    
}
