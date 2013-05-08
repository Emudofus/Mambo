

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FightTeamMemberTaxCollectorInformations extends FightTeamMemberInformations {
    public static final short TYPE_ID = 177;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short firstNameId;
    public short lastNameId;
    public short level;
    public int guildId;
    public int uid;
    
    public FightTeamMemberTaxCollectorInformations() { }
    
    public FightTeamMemberTaxCollectorInformations(int id, short firstNameId, short lastNameId, short level, int guildId, int uid) {
        super(id);
        this.firstNameId = firstNameId;
        this.lastNameId = lastNameId;
        this.level = level;
        this.guildId = guildId;
        this.uid = uid;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(firstNameId);
        buf.writeShort(lastNameId);
        buf.writeUByte(level);
        buf.writeInt(guildId);
        buf.writeInt(uid);
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
        level = buf.readUByte();
        if (level < 1 || level > 200)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 1 || level > 200");
        guildId = buf.readInt();
        if (guildId < 0)
            throw new RuntimeException("Forbidden value on guildId = " + guildId + ", it doesn't respect the following condition : guildId < 0");
        uid = buf.readInt();
        if (uid < 0)
            throw new RuntimeException("Forbidden value on uid = " + uid + ", it doesn't respect the following condition : uid < 0");
    }
    
}
