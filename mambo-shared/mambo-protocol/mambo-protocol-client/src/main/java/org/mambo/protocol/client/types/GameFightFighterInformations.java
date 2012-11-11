

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(teamId);
        writer.writeBoolean(alive);
        writer.writeShort(stats.getTypeId());
        stats.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        teamId = reader.readByte();
        if (teamId < 0)
            throw new RuntimeException("Forbidden value on teamId = " + teamId + ", it doesn't respect the following condition : teamId < 0");
        alive = reader.readBoolean();
        stats = ProtocolTypeManager.getInstance().build(reader.readShort(), GameFightMinimalStats.class);
        stats.deserialize(reader);
    }
    
}
