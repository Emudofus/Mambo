

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayTaxCollectorInformations extends GameRolePlayActorInformations {
    public static final short TYPE_ID = 148;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short firstNameId;
    public short lastNameId;
    public GuildInformations guildIdentity;
    public short guildLevel;
    public int taxCollectorAttack;
    
    public GameRolePlayTaxCollectorInformations() { }
    
    public GameRolePlayTaxCollectorInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, short firstNameId, short lastNameId, GuildInformations guildIdentity, short guildLevel, int taxCollectorAttack) {
        super(contextualId, look, disposition);
        this.firstNameId = firstNameId;
        this.lastNameId = lastNameId;
        this.guildIdentity = guildIdentity;
        this.guildLevel = guildLevel;
        this.taxCollectorAttack = taxCollectorAttack;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(firstNameId);
        buf.writeShort(lastNameId);
        guildIdentity.serialize(buf);
        buf.writeUByte(guildLevel);
        buf.writeInt(taxCollectorAttack);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        firstNameId = buf.readShort();
        if (firstNameId < 0)
            throw new RuntimeException("Forbidden value on firstNameId = " + firstNameId + ", it doesn't respect the following condition : firstNameId < 0");
        lastNameId = buf.readShort();
        if (lastNameId < 0)
            throw new RuntimeException("Forbidden value on lastNameId = " + lastNameId + ", it doesn't respect the following condition : lastNameId < 0");
        guildIdentity = new GuildInformations();
        guildIdentity.deserialize(buf);
        guildLevel = buf.readUByte();
        if (guildLevel < 0 || guildLevel > 255)
            throw new RuntimeException("Forbidden value on guildLevel = " + guildLevel + ", it doesn't respect the following condition : guildLevel < 0 || guildLevel > 255");
        taxCollectorAttack = buf.readInt();
    }
    
}
