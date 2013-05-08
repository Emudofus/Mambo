

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayPrismInformations extends GameRolePlayActorInformations {
    public static final short TYPE_ID = 161;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public ActorAlignmentInformations alignInfos;
    
    public GameRolePlayPrismInformations() { }
    
    public GameRolePlayPrismInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, ActorAlignmentInformations alignInfos) {
        super(contextualId, look, disposition);
        this.alignInfos = alignInfos;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        alignInfos.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        alignInfos = new ActorAlignmentInformations();
        alignInfos.deserialize(buf);
    }
    
}
