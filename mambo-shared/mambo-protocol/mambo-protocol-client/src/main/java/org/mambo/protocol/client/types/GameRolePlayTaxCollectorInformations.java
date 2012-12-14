

// Generated on 12/14/2012 18:44:21
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(firstNameId);
        writer.writeShort(lastNameId);
        guildIdentity.serialize(writer);
        writer.writeUnsignedByte(guildLevel);
        writer.writeInt(taxCollectorAttack);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        firstNameId = reader.readShort();
        if (firstNameId < 0)
            throw new RuntimeException("Forbidden value on firstNameId = " + firstNameId + ", it doesn't respect the following condition : firstNameId < 0");
        lastNameId = reader.readShort();
        if (lastNameId < 0)
            throw new RuntimeException("Forbidden value on lastNameId = " + lastNameId + ", it doesn't respect the following condition : lastNameId < 0");
        guildIdentity = new GuildInformations();
        guildIdentity.deserialize(reader);
        guildLevel = reader.readUnsignedByte();
        if (guildLevel < 0 || guildLevel > 255)
            throw new RuntimeException("Forbidden value on guildLevel = " + guildLevel + ", it doesn't respect the following condition : guildLevel < 0 || guildLevel > 255");
        taxCollectorAttack = reader.readInt();
    }
    
}
