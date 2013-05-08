

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayMountInformations extends GameRolePlayNamedActorInformations {
    public static final short TYPE_ID = 180;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public String ownerName;
    public short level;
    
    public GameRolePlayMountInformations() { }
    
    public GameRolePlayMountInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, String name, String ownerName, short level) {
        super(contextualId, look, disposition, name);
        this.ownerName = ownerName;
        this.level = level;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeString(ownerName);
        buf.writeUByte(level);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        ownerName = buf.readString();
        level = buf.readUByte();
        if (level < 0 || level > 255)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0 || level > 255");
    }
    
}
