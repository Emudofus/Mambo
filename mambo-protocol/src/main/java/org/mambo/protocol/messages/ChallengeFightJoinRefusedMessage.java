

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ChallengeFightJoinRefusedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5908;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int playerId;
    public byte reason;
    
    public ChallengeFightJoinRefusedMessage() { }
    
    public ChallengeFightJoinRefusedMessage(int playerId, byte reason) {
        this.playerId = playerId;
        this.reason = reason;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(playerId);
        buf.writeByte(reason);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        playerId = buf.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        reason = buf.readByte();
    }
    
}
