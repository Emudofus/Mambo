

// Generated on 12/14/2012 18:44:22
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameFightMonsterWithAlignmentInformations extends GameFightMonsterInformations {
    public static final short TYPE_ID = 203;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public ActorAlignmentInformations alignmentInfos;
    
    public GameFightMonsterWithAlignmentInformations() { }
    
    public GameFightMonsterWithAlignmentInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, boolean alive, GameFightMinimalStats stats, short creatureGenericId, byte creatureGrade, ActorAlignmentInformations alignmentInfos) {
        super(contextualId, look, disposition, teamId, alive, stats, creatureGenericId, creatureGrade);
        this.alignmentInfos = alignmentInfos;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        alignmentInfos.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        alignmentInfos = new ActorAlignmentInformations();
        alignmentInfos.deserialize(reader);
    }
    
}
