

// Generated on 12/14/2012 18:44:21
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    
    public GameFightCharacterInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, boolean alive, GameFightMinimalStats stats, String name, short level, ActorAlignmentInformations alignmentInfos, byte breed) {
        super(contextualId, look, disposition, teamId, alive, stats, name);
        this.level = level;
        this.alignmentInfos = alignmentInfos;
        this.breed = breed;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(level);
        alignmentInfos.serialize(writer);
        writer.writeByte(breed);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        level = reader.readShort();
        if (level < 0)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0");
        alignmentInfos = new ActorAlignmentInformations();
        alignmentInfos.deserialize(reader);
        breed = reader.readByte();
    }
    
}
