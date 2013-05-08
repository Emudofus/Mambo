

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(npcId);
        buf.writeBoolean(sex);
        buf.writeShort(specialArtworkId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        npcId = buf.readShort();
        if (npcId < 0)
            throw new RuntimeException("Forbidden value on npcId = " + npcId + ", it doesn't respect the following condition : npcId < 0");
        sex = buf.readBoolean();
        specialArtworkId = buf.readShort();
        if (specialArtworkId < 0)
            throw new RuntimeException("Forbidden value on specialArtworkId = " + specialArtworkId + ", it doesn't respect the following condition : specialArtworkId < 0");
    }
    
}
