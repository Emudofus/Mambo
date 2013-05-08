

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightCharacterInformations extends GameFightFighterNamedInformations {
    public static final short TYPE_ID = 46;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short level;
    public ActorAlignmentInformations alignmentInfos;
    public byte breed;
    
    public GameFightCharacterInformations() { }
    
    public GameFightCharacterInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, boolean alive, GameFightMinimalStats stats, String name, PlayerStatus status, short level, ActorAlignmentInformations alignmentInfos, byte breed) {
        super(contextualId, look, disposition, teamId, alive, stats, name, status);
        this.level = level;
        this.alignmentInfos = alignmentInfos;
        this.breed = breed;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(level);
        alignmentInfos.serialize(buf);
        buf.writeByte(breed);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        level = buf.readShort();
        if (level < 0)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0");
        alignmentInfos = new ActorAlignmentInformations();
        alignmentInfos.deserialize(buf);
        breed = buf.readByte();
    }
    
}
