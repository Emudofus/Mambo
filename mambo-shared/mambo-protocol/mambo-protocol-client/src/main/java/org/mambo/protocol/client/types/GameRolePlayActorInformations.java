

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
    }
    
}
