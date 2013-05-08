

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AlternativeMonstersInGroupLightInformations extends NetworkType {
    public static final short TYPE_ID = 394;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int playerCount;
    public MonsterInGroupLightInformations[] monsters;
    
    public AlternativeMonstersInGroupLightInformations() { }
    
    public AlternativeMonstersInGroupLightInformations(int playerCount, MonsterInGroupLightInformations[] monsters) {
        this.playerCount = playerCount;
        this.monsters = monsters;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(playerCount);
        buf.writeUShort(monsters.length);
        for (MonsterInGroupLightInformations entry : monsters) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        playerCount = buf.readInt();
        int limit = buf.readUShort();
        monsters = new MonsterInGroupLightInformations[limit];
        for (int i = 0; i < limit; i++) {
            monsters[i] = new MonsterInGroupLightInformations();
            monsters[i].deserialize(buf);
        }
    }
    
}
