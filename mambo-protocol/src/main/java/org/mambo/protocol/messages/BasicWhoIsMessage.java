

// Generated on 05/08/2013 19:37:41
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class BasicWhoIsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 180;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean self;
    public byte position;
    public String accountNickname;
    public int accountId;
    public String playerName;
    public int playerId;
    public short areaId;
    
    public BasicWhoIsMessage() { }
    
    public BasicWhoIsMessage(boolean self, byte position, String accountNickname, int accountId, String playerName, int playerId, short areaId) {
        this.self = self;
        this.position = position;
        this.accountNickname = accountNickname;
        this.accountId = accountId;
        this.playerName = playerName;
        this.playerId = playerId;
        this.areaId = areaId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(self);
        buf.writeByte(position);
        buf.writeString(accountNickname);
        buf.writeInt(accountId);
        buf.writeString(playerName);
        buf.writeInt(playerId);
        buf.writeShort(areaId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        self = buf.readBoolean();
        position = buf.readByte();
        accountNickname = buf.readString();
        accountId = buf.readInt();
        if (accountId < 0)
            throw new RuntimeException("Forbidden value on accountId = " + accountId + ", it doesn't respect the following condition : accountId < 0");
        playerName = buf.readString();
        playerId = buf.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        areaId = buf.readShort();
    }
    
}
