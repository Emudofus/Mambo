

// Generated on 11/11/2012 19:06:12
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameRolePlayCharacterInformations extends GameRolePlayHumanoidInformations {
    public static final short TYPE_ID = 36;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public ActorAlignmentInformations alignmentInfos;
    
    public GameRolePlayCharacterInformations() { }
    
    public GameRolePlayCharacterInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, String name, HumanInformations humanoidInfo, ActorAlignmentInformations alignmentInfos) {
        super(contextualId, look, disposition, name, humanoidInfo);
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
