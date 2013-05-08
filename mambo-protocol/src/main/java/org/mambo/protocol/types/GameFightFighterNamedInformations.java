

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightFighterNamedInformations extends GameFightFighterInformations {
    public static final short TYPE_ID = 158;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public String name;
    public PlayerStatus status;
    
    public GameFightFighterNamedInformations() { }
    
    public GameFightFighterNamedInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, boolean alive, GameFightMinimalStats stats, String name, PlayerStatus status) {
        super(contextualId, look, disposition, teamId, alive, stats);
        this.name = name;
        this.status = status;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeString(name);
        status.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        name = buf.readString();
        status = new PlayerStatus();
        status.deserialize(buf);
    }
    
}
