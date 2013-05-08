

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
    }
    
}
