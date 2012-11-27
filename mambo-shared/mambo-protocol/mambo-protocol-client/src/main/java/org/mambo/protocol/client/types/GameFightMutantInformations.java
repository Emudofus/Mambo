

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import org.mambo.core.io.*;

public class GameFightMutantInformations extends GameFightFighterNamedInformations {
    public static final short TYPE_ID = 50;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte powerLevel;
    
    public GameFightMutantInformations() { }
    
    public GameFightMutantInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, boolean alive, GameFightMinimalStats stats, String name, byte powerLevel) {
        super(contextualId, look, disposition, teamId, alive, stats, name);
        this.powerLevel = powerLevel;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(powerLevel);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        powerLevel = reader.readByte();
        if (powerLevel < 0)
            throw new RuntimeException("Forbidden value on powerLevel = " + powerLevel + ", it doesn't respect the following condition : powerLevel < 0");
    }
    
}
