

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import org.mambo.core.io.*;

public class GameRolePlayCharacterInformations extends GameRolePlayHumanoidInformations {
    public static final short TYPE_ID = 36;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public ActorAlignmentInformations alignmentInfos;
    
    public GameRolePlayCharacterInformations() { }
    
    public GameRolePlayCharacterInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, String name, HumanInformations humanoidInfo, int accountId, ActorAlignmentInformations alignmentInfos) {
        super(contextualId, look, disposition, name, humanoidInfo, accountId);
        this.alignmentInfos = alignmentInfos;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        alignmentInfos.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        alignmentInfos = new ActorAlignmentInformations();
        alignmentInfos.deserialize(reader);
    }
    
}
