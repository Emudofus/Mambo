

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GroupMonsterStaticInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 140;
    
    
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
    public void serialize(DataWriterInterface writer) {
        mainCreatureLightInfos.serialize(writer);
        writer.writeUnsignedShort(underlings.length);
        for (MonsterInGroupInformations entry : underlings) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        mainCreatureLightInfos = new MonsterInGroupLightInformations();
        mainCreatureLightInfos.deserialize(reader);
        int limit = reader.readUnsignedShort();
        underlings = new MonsterInGroupInformations[limit];
        for (int i = 0; i < limit; i++) {
            underlings[i] = new MonsterInGroupInformations();
            underlings[i].deserialize(reader);
        }
    }
    
}
