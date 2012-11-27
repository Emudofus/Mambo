

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import org.mambo.core.io.*;

public class GameFightAIInformations extends GameFightFighterInformations {
    public static final short TYPE_ID = 151;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    
    public GameFightAIInformations() { }
    
    public GameFightAIInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, boolean alive, GameFightMinimalStats stats) {
        super(contextualId, look, disposition, teamId, alive, stats);
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
