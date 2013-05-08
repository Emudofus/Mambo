

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FriendInformations extends AbstractContactInformations {
    public static final short TYPE_ID = 78;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte playerState;
    public int lastConnection;
    public int achievementPoints;
    
    public FriendInformations() { }
    
    public FriendInformations(int accountId, String accountName, byte playerState, int lastConnection, int achievementPoints) {
        super(accountId, accountName);
        this.playerState = playerState;
        this.lastConnection = lastConnection;
        this.achievementPoints = achievementPoints;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(playerState);
        buf.writeInt(lastConnection);
        buf.writeInt(achievementPoints);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        playerState = buf.readByte();
        if (playerState < 0)
            throw new RuntimeException("Forbidden value on playerState = " + playerState + ", it doesn't respect the following condition : playerState < 0");
        lastConnection = buf.readInt();
        if (lastConnection < 0)
            throw new RuntimeException("Forbidden value on lastConnection = " + lastConnection + ", it doesn't respect the following condition : lastConnection < 0");
        achievementPoints = buf.readInt();
    }
    
}
