

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FriendOnlineInformations extends FriendInformations {
    public static final short TYPE_ID = 92;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int playerId;
    public String playerName;
    public short level;
    public byte alignmentSide;
    public byte breed;
    public boolean sex;
    public BasicGuildInformations guildInfo;
    public byte moodSmileyId;
    public PlayerStatus status;
    
    public FriendOnlineInformations() { }
    
    public FriendOnlineInformations(int accountId, String accountName, byte playerState, int lastConnection, int achievementPoints, int playerId, String playerName, short level, byte alignmentSide, byte breed, boolean sex, BasicGuildInformations guildInfo, byte moodSmileyId, PlayerStatus status) {
        super(accountId, accountName, playerState, lastConnection, achievementPoints);
        this.playerId = playerId;
        this.playerName = playerName;
        this.level = level;
        this.alignmentSide = alignmentSide;
        this.breed = breed;
        this.sex = sex;
        this.guildInfo = guildInfo;
        this.moodSmileyId = moodSmileyId;
        this.status = status;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(playerId);
        buf.writeString(playerName);
        buf.writeShort(level);
        buf.writeByte(alignmentSide);
        buf.writeByte(breed);
        buf.writeBoolean(sex);
        guildInfo.serialize(buf);
        buf.writeByte(moodSmileyId);
        buf.writeShort(status.getTypeId());
        status.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        playerId = buf.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        playerName = buf.readString();
        level = buf.readShort();
        if (level < 0 || level > 200)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0 || level > 200");
        alignmentSide = buf.readByte();
        breed = buf.readByte();
        if (breed < PlayableBreedEnum.Feca.value() || breed > PlayableBreedEnum.Steamer.value())
            throw new RuntimeException("Forbidden value on breed = " + breed + ", it doesn't respect the following condition : breed < PlayableBreedEnum.Feca.value() || breed > PlayableBreedEnum.Steamer.value()");
        sex = buf.readBoolean();
        guildInfo = new BasicGuildInformations();
        guildInfo.deserialize(buf);
        moodSmileyId = buf.readByte();
        status = ProtocolTypeManager.getInstance().build(buf.readShort());
        status.deserialize(buf);
    }
    
}
