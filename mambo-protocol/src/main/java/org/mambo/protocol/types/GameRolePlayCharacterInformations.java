

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        alignmentInfos.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        alignmentInfos = new ActorAlignmentInformations();
        alignmentInfos.deserialize(buf);
    }
    
}
