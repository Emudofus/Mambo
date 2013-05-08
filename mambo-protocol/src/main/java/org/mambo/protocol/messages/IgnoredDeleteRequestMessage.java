

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class IgnoredDeleteRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5680;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int accountId;
    public boolean session;
    
    public IgnoredDeleteRequestMessage() { }
    
    public IgnoredDeleteRequestMessage(int accountId, boolean session) {
        this.accountId = accountId;
        this.session = session;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(accountId);
        buf.writeBoolean(session);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        accountId = buf.readInt();
        if (accountId < 0)
            throw new RuntimeException("Forbidden value on accountId = " + accountId + ", it doesn't respect the following condition : accountId < 0");
        session = buf.readBoolean();
    }
    
}
