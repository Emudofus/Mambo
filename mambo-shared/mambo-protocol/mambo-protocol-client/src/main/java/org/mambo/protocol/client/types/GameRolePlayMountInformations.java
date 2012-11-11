

// Generated on 11/11/2012 19:06:12
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeString(ownerName);
        writer.writeUnsignedByte(level);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        ownerName = reader.readString();
        level = reader.readUnsignedByte();
        if (level < 0 || level > 255)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0 || level > 255");
    }
    
}
