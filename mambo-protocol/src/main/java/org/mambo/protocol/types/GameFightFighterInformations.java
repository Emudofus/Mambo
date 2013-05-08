

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightFighterInformations extends GameContextActorInformations {
    public static final short TYPE_ID = 143;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte teamId;
    public boolean alive;
    public GameFightMinimalStats stats;
    
    public GameFightFighterInformations() { }
    
    public GameFightFighterInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, boolean alive, GameFightMinimalStats stats) {
        super(contextualId, look, disposition);
        this.teamId = teamId;
        this.alive = alive;
        this.stats = stats;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(teamId);
        buf.writeBoolean(alive);
        buf.writeShort(stats.getTypeId());
        stats.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        teamId = buf.readByte();
        if (teamId < 0)
            throw new RuntimeException("Forbidden value on teamId = " + teamId + ", it doesn't respect the following condition : teamId < 0");
        alive = buf.readBoolean();
        stats = ProtocolTypeManager.getInstance().build(buf.readShort());
        stats.deserialize(buf);
    }
    
}
