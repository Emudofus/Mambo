

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedShort(alternatives.length);
        for (AlternativeMonstersInGroupLightInformations entry : alternatives) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        int limit = reader.readUnsignedShort();
        alternatives = new AlternativeMonstersInGroupLightInformations[limit];
        for (int i = 0; i < limit; i++) {
            alternatives[i] = new AlternativeMonstersInGroupLightInformations();
            alternatives[i].deserialize(reader);
        }
    }
    
}
