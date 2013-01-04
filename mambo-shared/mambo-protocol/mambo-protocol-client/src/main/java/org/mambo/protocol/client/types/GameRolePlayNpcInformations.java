

// Generated on 01/04/2013 14:54:45
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameRolePlayNpcInformations extends GameRolePlayActorInformations {
    public static final short TYPE_ID = 156;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short npcId;
    public boolean sex;
    public short specialArtworkId;
    
    public GameRolePlayNpcInformations() { }
    
    public GameRolePlayNpcInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, short npcId, boolean sex, short specialArtworkId) {
        super(contextualId, look, disposition);
        this.npcId = npcId;
        this.sex = sex;
        this.specialArtworkId = specialArtworkId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(npcId);
        writer.writeBoolean(sex);
        writer.writeShort(specialArtworkId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        npcId = reader.readShort();
        if (npcId < 0)
            throw new RuntimeException("Forbidden value on npcId = " + npcId + ", it doesn't respect the following condition : npcId < 0");
        sex = reader.readBoolean();
        specialArtworkId = reader.readShort();
        if (specialArtworkId < 0)
            throw new RuntimeException("Forbidden value on specialArtworkId = " + specialArtworkId + ", it doesn't respect the following condition : specialArtworkId < 0");
    }
    
}
