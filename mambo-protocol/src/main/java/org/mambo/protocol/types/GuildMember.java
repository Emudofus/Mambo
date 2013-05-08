

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildMember extends CharacterMinimalInformations {
    public static final short TYPE_ID = 88;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte breed;
    public boolean sex;
    public short rank;
    public double givenExperience;
    public byte experienceGivenPercent;
    public long rights;
    public byte connected;
    public byte alignmentSide;
    public int hoursSinceLastConnection;
    public byte moodSmileyId;
    public int accountId;
    public int achievementPoints;
    public PlayerStatus status;
    
    public GuildMember() { }
    
    public GuildMember(int id, short level, String name, byte breed, boolean sex, short rank, double givenExperience, byte experienceGivenPercent, long rights, byte connected, byte alignmentSide, int hoursSinceLastConnection, byte moodSmileyId, int accountId, int achievementPoints, PlayerStatus status) {
        super(id, level, name);
        this.breed = breed;
        this.sex = sex;
        this.rank = rank;
        this.givenExperience = givenExperience;
        this.experienceGivenPercent = experienceGivenPercent;
        this.rights = rights;
        this.connected = connected;
        this.alignmentSide = alignmentSide;
        this.hoursSinceLastConnection = hoursSinceLastConnection;
        this.moodSmileyId = moodSmileyId;
        this.accountId = accountId;
        this.achievementPoints = achievementPoints;
        this.status = status;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(breed);
        buf.writeBoolean(sex);
        buf.writeShort(rank);
        buf.writeDouble(givenExperience);
        buf.writeByte(experienceGivenPercent);
        buf.writeUInt(rights);
        buf.writeByte(connected);
        buf.writeByte(alignmentSide);
        buf.writeUShort(hoursSinceLastConnection);
        buf.writeByte(moodSmileyId);
        buf.writeInt(accountId);
        buf.writeInt(achievementPoints);
        buf.writeShort(status.getTypeId());
        status.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        breed = buf.readByte();
        sex = buf.readBoolean();
        rank = buf.readShort();
        if (rank < 0)
            throw new RuntimeException("Forbidden value on rank = " + rank + ", it doesn't respect the following condition : rank < 0");
        givenExperience = buf.readDouble();
        if (givenExperience < 0)
            throw new RuntimeException("Forbidden value on givenExperience = " + givenExperience + ", it doesn't respect the following condition : givenExperience < 0");
        experienceGivenPercent = buf.readByte();
        if (experienceGivenPercent < 0 || experienceGivenPercent > 100)
            throw new RuntimeException("Forbidden value on experienceGivenPercent = " + experienceGivenPercent + ", it doesn't respect the following condition : experienceGivenPercent < 0 || experienceGivenPercent > 100");
        rights = buf.readUInt();
        if (rights < 0 || rights > 4294967295L)
            throw new RuntimeException("Forbidden value on rights = " + rights + ", it doesn't respect the following condition : rights < 0 || rights > 4294967295L");
        connected = buf.readByte();
        if (connected < 0)
            throw new RuntimeException("Forbidden value on connected = " + connected + ", it doesn't respect the following condition : connected < 0");
        alignmentSide = buf.readByte();
        hoursSinceLastConnection = buf.readUShort();
        if (hoursSinceLastConnection < 0 || hoursSinceLastConnection > 65535)
            throw new RuntimeException("Forbidden value on hoursSinceLastConnection = " + hoursSinceLastConnection + ", it doesn't respect the following condition : hoursSinceLastConnection < 0 || hoursSinceLastConnection > 65535");
        moodSmileyId = buf.readByte();
        accountId = buf.readInt();
        if (accountId < 0)
            throw new RuntimeException("Forbidden value on accountId = " + accountId + ", it doesn't respect the following condition : accountId < 0");
        achievementPoints = buf.readInt();
        status = ProtocolTypeManager.getInstance().build(buf.readShort());
        status.deserialize(buf);
    }
    
}
