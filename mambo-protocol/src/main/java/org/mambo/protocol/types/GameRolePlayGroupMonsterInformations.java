

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayGroupMonsterInformations extends GameRolePlayActorInformations {
    public static final short TYPE_ID = 160;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public GroupMonsterStaticInformations staticInfos;
    public short ageBonus;
    public byte lootShare;
    public byte alignmentSide;
    public boolean keyRingBonus;
    
    public GameRolePlayGroupMonsterInformations() { }
    
    public GameRolePlayGroupMonsterInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, GroupMonsterStaticInformations staticInfos, short ageBonus, byte lootShare, byte alignmentSide, boolean keyRingBonus) {
        super(contextualId, look, disposition);
        this.staticInfos = staticInfos;
        this.ageBonus = ageBonus;
        this.lootShare = lootShare;
        this.alignmentSide = alignmentSide;
        this.keyRingBonus = keyRingBonus;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(staticInfos.getTypeId());
        staticInfos.serialize(buf);
        buf.writeShort(ageBonus);
        buf.writeByte(lootShare);
        buf.writeByte(alignmentSide);
        buf.writeBoolean(keyRingBonus);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        staticInfos = ProtocolTypeManager.getInstance().build(buf.readShort());
        staticInfos.deserialize(buf);
        ageBonus = buf.readShort();
        if (ageBonus < -1 || ageBonus > 1000)
            throw new RuntimeException("Forbidden value on ageBonus = " + ageBonus + ", it doesn't respect the following condition : ageBonus < -1 || ageBonus > 1000");
        lootShare = buf.readByte();
        if (lootShare < -1 || lootShare > 8)
            throw new RuntimeException("Forbidden value on lootShare = " + lootShare + ", it doesn't respect the following condition : lootShare < -1 || lootShare > 8");
        alignmentSide = buf.readByte();
        keyRingBonus = buf.readBoolean();
    }
    
}
