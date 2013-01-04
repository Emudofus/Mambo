

// Generated on 01/04/2013 14:54:46
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameRolePlayPrismInformations extends GameRolePlayActorInformations {
    public static final short TYPE_ID = 161;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public ActorAlignmentInformations alignInfos;
    
    public GameRolePlayPrismInformations() { }
    
    public GameRolePlayPrismInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, ActorAlignmentInformations alignInfos) {
        super(contextualId, look, disposition);
        this.alignInfos = alignInfos;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        alignInfos.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        alignInfos = new ActorAlignmentInformations();
        alignInfos.deserialize(reader);
    }
    
}
