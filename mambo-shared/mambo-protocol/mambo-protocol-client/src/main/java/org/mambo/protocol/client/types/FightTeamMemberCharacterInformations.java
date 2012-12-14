

// Generated on 12/14/2012 18:44:21
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeString(name);
        writer.writeShort(level);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        name = reader.readString();
        level = reader.readShort();
        if (level < 0)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0");
    }
    
}
