

// Generated on 12/14/2012 18:44:22
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AlternativeMonstersInGroupLightInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 394;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(playerCount);
        writer.writeUnsignedShort(monsters.length);
        for (MonsterInGroupLightInformations entry : monsters) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        playerCount = reader.readInt();
        int limit = reader.readUnsignedShort();
        monsters = new MonsterInGroupLightInformations[limit];
        for (int i = 0; i < limit; i++) {
            monsters[i] = new MonsterInGroupLightInformations();
            monsters[i].deserialize(reader);
        }
    }
    
}
