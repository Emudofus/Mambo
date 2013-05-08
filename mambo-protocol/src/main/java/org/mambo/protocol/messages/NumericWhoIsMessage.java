

// Generated on 05/08/2013 19:37:41
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class NumericWhoIsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6297;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int playerId;
    public int accountId;
    
    public NumericWhoIsMessage() { }
    
    public NumericWhoIsMessage(int playerId, int accountId) {
        this.playerId = playerId;
        this.accountId = accountId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(playerId);
        buf.writeInt(accountId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        playerId = buf.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        accountId = buf.readInt();
        if (accountId < 0)
            throw new RuntimeException("Forbidden value on accountId = " + accountId + ", it doesn't respect the following condition : accountId < 0");
    }
    
}
