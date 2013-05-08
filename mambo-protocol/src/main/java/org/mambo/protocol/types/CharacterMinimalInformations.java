

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CharacterMinimalInformations extends AbstractCharacterInformation {
    public static final short TYPE_ID = 110;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short level;
    public String name;
    
    public CharacterMinimalInformations() { }
    
    public CharacterMinimalInformations(int id, short level, String name) {
        super(id);
        this.level = level;
        this.name = name;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUByte(level);
        buf.writeString(name);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        level = buf.readUByte();
        if (level < 1 || level > 200)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 1 || level > 200");
        name = buf.readString();
    }
    
}
