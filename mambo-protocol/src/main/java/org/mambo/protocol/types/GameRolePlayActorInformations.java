

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayActorInformations extends GameContextActorInformations {
    public static final short TYPE_ID = 141;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    
    public GameRolePlayActorInformations() { }
    
    public GameRolePlayActorInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition) {
        super(contextualId, look, disposition);
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
    }
    
}
