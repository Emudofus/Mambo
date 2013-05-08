

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightMutantInformations extends GameFightFighterNamedInformations {
    public static final short TYPE_ID = 50;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte powerLevel;
    
    public GameFightMutantInformations() { }
    
    public GameFightMutantInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, boolean alive, GameFightMinimalStats stats, String name, PlayerStatus status, byte powerLevel) {
        super(contextualId, look, disposition, teamId, alive, stats, name, status);
        this.powerLevel = powerLevel;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(powerLevel);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        powerLevel = buf.readByte();
        if (powerLevel < 0)
            throw new RuntimeException("Forbidden value on powerLevel = " + powerLevel + ", it doesn't respect the following condition : powerLevel < 0");
    }
    
}
