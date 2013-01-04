

// Generated on 01/04/2013 14:54:44
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedByte(level);
        writer.writeString(name);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        level = reader.readUnsignedByte();
        if (level < 1 || level > 200)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 1 || level > 200");
        name = reader.readString();
    }
    
}
