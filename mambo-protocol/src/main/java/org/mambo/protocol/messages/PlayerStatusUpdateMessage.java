

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PlayerStatusUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6386;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int accountId;
    public int playerId;
    public PlayerStatus status;
    
    public PlayerStatusUpdateMessage() { }
    
    public PlayerStatusUpdateMessage(int accountId, int playerId, PlayerStatus status) {
        this.accountId = accountId;
        this.playerId = playerId;
        this.status = status;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(accountId);
        buf.writeInt(playerId);
        buf.writeShort(status.getTypeId());
        status.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        accountId = buf.readInt();
        if (accountId < 0)
            throw new RuntimeException("Forbidden value on accountId = " + accountId + ", it doesn't respect the following condition : accountId < 0");
        playerId = buf.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        status = ProtocolTypeManager.getInstance().build(buf.readShort());
        status.deserialize(buf);
    }
    
}
