

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeString(name);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        name = reader.readString();
    }
    
}
