

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class DungeonPartyFinderPlayer extends NetworkType {
    public static final short TYPE_ID = 373;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int playerId;
    public String playerName;
    public byte breed;
    public boolean sex;
    public short level;
    
    public DungeonPartyFinderPlayer() { }
    
    public DungeonPartyFinderPlayer(int playerId, String playerName, byte breed, boolean sex, short level) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.breed = breed;
        this.sex = sex;
        this.level = level;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(playerId);
        buf.writeString(playerName);
        buf.writeByte(breed);
        buf.writeBoolean(sex);
        buf.writeShort(level);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        playerId = buf.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        playerName = buf.readString();
        breed = buf.readByte();
        if (breed < PlayableBreedEnum.Feca.value() || breed > PlayableBreedEnum.Steamer.value())
            throw new RuntimeException("Forbidden value on breed = " + breed + ", it doesn't respect the following condition : breed < PlayableBreedEnum.Feca.value() || breed > PlayableBreedEnum.Steamer.value()");
        sex = buf.readBoolean();
        level = buf.readShort();
        if (level < 0)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0");
    }
    
}
