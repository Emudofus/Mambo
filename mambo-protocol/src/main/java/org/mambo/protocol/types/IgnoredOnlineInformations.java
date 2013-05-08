

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class IgnoredOnlineInformations extends IgnoredInformations {
    public static final short TYPE_ID = 105;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int playerId;
    public String playerName;
    public byte breed;
    public boolean sex;
    
    public IgnoredOnlineInformations() { }
    
    public IgnoredOnlineInformations(int accountId, String accountName, int playerId, String playerName, byte breed, boolean sex) {
        super(accountId, accountName);
        this.playerId = playerId;
        this.playerName = playerName;
        this.breed = breed;
        this.sex = sex;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(playerId);
        buf.writeString(playerName);
        buf.writeByte(breed);
        buf.writeBoolean(sex);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        playerId = buf.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        playerName = buf.readString();
        breed = buf.readByte();
        if (breed < PlayableBreedEnum.Feca.value() || breed > PlayableBreedEnum.Steamer.value())
            throw new RuntimeException("Forbidden value on breed = " + breed + ", it doesn't respect the following condition : breed < PlayableBreedEnum.Feca.value() || breed > PlayableBreedEnum.Steamer.value()");
        sex = buf.readBoolean();
    }
    
}
