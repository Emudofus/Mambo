

// Generated on 12/14/2012 18:44:22
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(staticInfos.getTypeId());
        staticInfos.serialize(writer);
        writer.writeShort(ageBonus);
        writer.writeByte(lootShare);
        writer.writeByte(alignmentSide);
        writer.writeBoolean(keyRingBonus);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        staticInfos = ProtocolTypeManager.getInstance().build(reader.readShort(), GroupMonsterStaticInformations.class);
        staticInfos.deserialize(reader);
        ageBonus = reader.readShort();
        if (ageBonus < -1 || ageBonus > 1000)
            throw new RuntimeException("Forbidden value on ageBonus = " + ageBonus + ", it doesn't respect the following condition : ageBonus < -1 || ageBonus > 1000");
        lootShare = reader.readByte();
        if (lootShare < -1 || lootShare > 8)
            throw new RuntimeException("Forbidden value on lootShare = " + lootShare + ", it doesn't respect the following condition : lootShare < -1 || lootShare > 8");
        alignmentSide = reader.readByte();
        keyRingBonus = reader.readBoolean();
    }
    
}
