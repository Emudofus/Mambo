

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayNamedActorInformations extends GameRolePlayActorInformations {
    public static final short TYPE_ID = 154;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public String name;
    
    public GameRolePlayNamedActorInformations() { }
    
    public GameRolePlayNamedActorInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, String name) {
        super(contextualId, look, disposition);
        this.name = name;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeString(name);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        name = buf.readString();
    }
    
}
