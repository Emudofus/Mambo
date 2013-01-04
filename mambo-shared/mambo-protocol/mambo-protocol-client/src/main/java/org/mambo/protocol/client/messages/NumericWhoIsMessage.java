

// Generated on 01/04/2013 14:54:20
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(playerId);
        writer.writeInt(accountId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        playerId = reader.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        accountId = reader.readInt();
        if (accountId < 0)
            throw new RuntimeException("Forbidden value on accountId = " + accountId + ", it doesn't respect the following condition : accountId < 0");
    }
    
}
