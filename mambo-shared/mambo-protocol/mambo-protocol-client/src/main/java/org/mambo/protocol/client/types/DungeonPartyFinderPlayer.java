

// Generated on 12/14/2012 18:44:22
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class DungeonPartyFinderPlayer implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 373;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(playerId);
        writer.writeString(playerName);
        writer.writeByte(breed);
        writer.writeBoolean(sex);
        writer.writeShort(level);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        playerId = reader.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        playerName = reader.readString();
        breed = reader.readByte();
        if (breed < PlayableBreedEnum.Feca.value() || breed > PlayableBreedEnum.Steamer.value())
            throw new RuntimeException("Forbidden value on breed = " + breed + ", it doesn't respect the following condition : breed < PlayableBreedEnum.Feca.value() || breed > PlayableBreedEnum.Steamer.value()");
        sex = reader.readBoolean();
        level = reader.readShort();
        if (level < 0)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0");
    }
    
}
