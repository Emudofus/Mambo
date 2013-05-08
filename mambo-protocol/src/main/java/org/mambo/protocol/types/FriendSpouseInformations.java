

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FriendSpouseInformations extends NetworkType {
    public static final short TYPE_ID = 77;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int spouseAccountId;
    public int spouseId;
    public String spouseName;
    public short spouseLevel;
    public byte breed;
    public byte sex;
    public EntityLook spouseEntityLook;
    public BasicGuildInformations guildInfo;
    public byte alignmentSide;
    
    public FriendSpouseInformations() { }
    
    public FriendSpouseInformations(int spouseAccountId, int spouseId, String spouseName, short spouseLevel, byte breed, byte sex, EntityLook spouseEntityLook, BasicGuildInformations guildInfo, byte alignmentSide) {
        this.spouseAccountId = spouseAccountId;
        this.spouseId = spouseId;
        this.spouseName = spouseName;
        this.spouseLevel = spouseLevel;
        this.breed = breed;
        this.sex = sex;
        this.spouseEntityLook = spouseEntityLook;
        this.guildInfo = guildInfo;
        this.alignmentSide = alignmentSide;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(spouseAccountId);
        buf.writeInt(spouseId);
        buf.writeString(spouseName);
        buf.writeUByte(spouseLevel);
        buf.writeByte(breed);
        buf.writeByte(sex);
        spouseEntityLook.serialize(buf);
        guildInfo.serialize(buf);
        buf.writeByte(alignmentSide);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        spouseAccountId = buf.readInt();
        if (spouseAccountId < 0)
            throw new RuntimeException("Forbidden value on spouseAccountId = " + spouseAccountId + ", it doesn't respect the following condition : spouseAccountId < 0");
        spouseId = buf.readInt();
        if (spouseId < 0)
            throw new RuntimeException("Forbidden value on spouseId = " + spouseId + ", it doesn't respect the following condition : spouseId < 0");
        spouseName = buf.readString();
        spouseLevel = buf.readUByte();
        if (spouseLevel < 1 || spouseLevel > 200)
            throw new RuntimeException("Forbidden value on spouseLevel = " + spouseLevel + ", it doesn't respect the following condition : spouseLevel < 1 || spouseLevel > 200");
        breed = buf.readByte();
        sex = buf.readByte();
        spouseEntityLook = new EntityLook();
        spouseEntityLook.deserialize(buf);
        guildInfo = new BasicGuildInformations();
        guildInfo.deserialize(buf);
        alignmentSide = buf.readByte();
    }
    
}
