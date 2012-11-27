

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterMinimalInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 110;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int id;
    public short level;
    public String name;
    
    public CharacterMinimalInformations() { }
    
    public CharacterMinimalInformations(int id, short level, String name) {
        this.id = id;
        this.level = level;
        this.name = name;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(id);
        writer.writeUnsignedByte(level);
        writer.writeString(name);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readInt();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
        level = reader.readUnsignedByte();
        if (level < 1 || level > 200)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 1 || level > 200");
        name = reader.readString();
    }
    
}
