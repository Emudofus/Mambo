

// Generated on 12/14/2012 18:44:23
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class FriendOnlineInformations extends FriendInformations {
    public static final short TYPE_ID = 92;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public String playerName;
    public short level;
    public byte alignmentSide;
    public byte breed;
    public boolean sex;
    public BasicGuildInformations guildInfo;
    public byte moodSmileyId;
    
    public FriendOnlineInformations() { }
    
    public FriendOnlineInformations(int accountId, String accountName, byte playerState, int lastConnection, int achievementPoints, String playerName, short level, byte alignmentSide, byte breed, boolean sex, BasicGuildInformations guildInfo, byte moodSmileyId) {
        super(accountId, accountName, playerState, lastConnection, achievementPoints);
        this.playerName = playerName;
        this.level = level;
        this.alignmentSide = alignmentSide;
        this.breed = breed;
        this.sex = sex;
        this.guildInfo = guildInfo;
        this.moodSmileyId = moodSmileyId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeString(playerName);
        writer.writeShort(level);
        writer.writeByte(alignmentSide);
        writer.writeByte(breed);
        writer.writeBoolean(sex);
        guildInfo.serialize(writer);
        writer.writeByte(moodSmileyId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        playerName = reader.readString();
        level = reader.readShort();
        if (level < 0 || level > 200)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0 || level > 200");
        alignmentSide = reader.readByte();
        breed = reader.readByte();
        if (breed < PlayableBreedEnum.Feca.value() || breed > PlayableBreedEnum.Steamer.value())
            throw new RuntimeException("Forbidden value on breed = " + breed + ", it doesn't respect the following condition : breed < PlayableBreedEnum.Feca.value() || breed > PlayableBreedEnum.Steamer.value()");
        sex = reader.readBoolean();
        guildInfo = new BasicGuildInformations();
        guildInfo.deserialize(reader);
        moodSmileyId = reader.readByte();
    }
    
}
