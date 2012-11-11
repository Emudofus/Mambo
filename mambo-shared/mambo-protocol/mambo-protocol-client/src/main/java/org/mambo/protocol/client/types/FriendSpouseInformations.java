

// Generated on 11/11/2012 19:06:13
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class FriendSpouseInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 77;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(spouseAccountId);
        writer.writeInt(spouseId);
        writer.writeString(spouseName);
        writer.writeUnsignedByte(spouseLevel);
        writer.writeByte(breed);
        writer.writeByte(sex);
        spouseEntityLook.serialize(writer);
        guildInfo.serialize(writer);
        writer.writeByte(alignmentSide);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        spouseAccountId = reader.readInt();
        if (spouseAccountId < 0)
            throw new RuntimeException("Forbidden value on spouseAccountId = " + spouseAccountId + ", it doesn't respect the following condition : spouseAccountId < 0");
        spouseId = reader.readInt();
        if (spouseId < 0)
            throw new RuntimeException("Forbidden value on spouseId = " + spouseId + ", it doesn't respect the following condition : spouseId < 0");
        spouseName = reader.readString();
        spouseLevel = reader.readUnsignedByte();
        if (spouseLevel < 1 || spouseLevel > 200)
            throw new RuntimeException("Forbidden value on spouseLevel = " + spouseLevel + ", it doesn't respect the following condition : spouseLevel < 1 || spouseLevel > 200");
        breed = reader.readByte();
        sex = reader.readByte();
        spouseEntityLook = new EntityLook();
        spouseEntityLook.deserialize(reader);
        guildInfo = new BasicGuildInformations();
        guildInfo.deserialize(reader);
        alignmentSide = reader.readByte();
    }
    
}
