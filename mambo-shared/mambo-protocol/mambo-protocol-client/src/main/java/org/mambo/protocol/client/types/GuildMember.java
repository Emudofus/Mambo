

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    
    public GuildMember() { }
    
    public GuildMember(int id, short level, String name, byte breed, boolean sex, short rank, double givenExperience, byte experienceGivenPercent, long rights, byte connected, byte alignmentSide, int hoursSinceLastConnection, byte moodSmileyId, int accountId) {
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
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(breed);
        writer.writeBoolean(sex);
        writer.writeShort(rank);
        writer.writeDouble(givenExperience);
        writer.writeByte(experienceGivenPercent);
        writer.writeUnsignedInt(rights);
        writer.writeByte(connected);
        writer.writeByte(alignmentSide);
        writer.writeUnsignedShort(hoursSinceLastConnection);
        writer.writeByte(moodSmileyId);
        writer.writeInt(accountId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        breed = reader.readByte();
        sex = reader.readBoolean();
        rank = reader.readShort();
        if (rank < 0)
            throw new RuntimeException("Forbidden value on rank = " + rank + ", it doesn't respect the following condition : rank < 0");
        givenExperience = reader.readDouble();
        if (givenExperience < 0)
            throw new RuntimeException("Forbidden value on givenExperience = " + givenExperience + ", it doesn't respect the following condition : givenExperience < 0");
        experienceGivenPercent = reader.readByte();
        if (experienceGivenPercent < 0 || experienceGivenPercent > 100)
            throw new RuntimeException("Forbidden value on experienceGivenPercent = " + experienceGivenPercent + ", it doesn't respect the following condition : experienceGivenPercent < 0 || experienceGivenPercent > 100");
        rights = reader.readUnsignedInt();
        if (rights < 0 || rights > 4294967295L)
            throw new RuntimeException("Forbidden value on rights = " + rights + ", it doesn't respect the following condition : rights < 0 || rights > 4294967295L");
        connected = reader.readByte();
        if (connected < 0)
            throw new RuntimeException("Forbidden value on connected = " + connected + ", it doesn't respect the following condition : connected < 0");
        alignmentSide = reader.readByte();
        hoursSinceLastConnection = reader.readUnsignedShort();
        if (hoursSinceLastConnection < 0 || hoursSinceLastConnection > 65535)
            throw new RuntimeException("Forbidden value on hoursSinceLastConnection = " + hoursSinceLastConnection + ", it doesn't respect the following condition : hoursSinceLastConnection < 0 || hoursSinceLastConnection > 65535");
        moodSmileyId = reader.readByte();
        accountId = reader.readInt();
        if (accountId < 0)
            throw new RuntimeException("Forbidden value on accountId = " + accountId + ", it doesn't respect the following condition : accountId < 0");
    }
    
}
