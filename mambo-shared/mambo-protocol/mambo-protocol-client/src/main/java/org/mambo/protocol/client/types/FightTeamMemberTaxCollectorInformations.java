

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(firstNameId);
        writer.writeShort(lastNameId);
        writer.writeUnsignedByte(level);
        writer.writeInt(guildId);
        writer.writeInt(uid);
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
        level = reader.readUnsignedByte();
        if (level < 1 || level > 200)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 1 || level > 200");
        guildId = reader.readInt();
        if (guildId < 0)
            throw new RuntimeException("Forbidden value on guildId = " + guildId + ", it doesn't respect the following condition : guildId < 0");
        uid = reader.readInt();
        if (uid < 0)
            throw new RuntimeException("Forbidden value on uid = " + uid + ", it doesn't respect the following condition : uid < 0");
    }
    
}
