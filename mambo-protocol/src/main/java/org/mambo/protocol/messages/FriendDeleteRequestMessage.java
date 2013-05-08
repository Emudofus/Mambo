

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FriendDeleteRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5603;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int accountId;
    
    public FriendDeleteRequestMessage() { }
    
    public FriendDeleteRequestMessage(int accountId) {
        this.accountId = accountId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(accountId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        accountId = buf.readInt();
        if (accountId < 0)
            throw new RuntimeException("Forbidden value on accountId = " + accountId + ", it doesn't respect the following condition : accountId < 0");
    }
    
}
