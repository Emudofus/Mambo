

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FightTeamMemberCharacterInformations extends FightTeamMemberInformations {
    public static final short TYPE_ID = 13;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public String name;
    public short level;
    
    public FightTeamMemberCharacterInformations() { }
    
    public FightTeamMemberCharacterInformations(int id, String name, short level) {
        super(id);
        this.name = name;
        this.level = level;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeString(name);
        buf.writeShort(level);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        name = buf.readString();
        level = buf.readShort();
        if (level < 0)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0");
    }
    
}
