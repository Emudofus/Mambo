

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ChatSmileyMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 801;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int entityId;
    public byte smileyId;
    public int accountId;
    
    public ChatSmileyMessage() { }
    
    public ChatSmileyMessage(int entityId, byte smileyId, int accountId) {
        this.entityId = entityId;
        this.smileyId = smileyId;
        this.accountId = accountId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(entityId);
        buf.writeByte(smileyId);
        buf.writeInt(accountId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        entityId = buf.readInt();
        smileyId = buf.readByte();
        if (smileyId < 0)
            throw new RuntimeException("Forbidden value on smileyId = " + smileyId + ", it doesn't respect the following condition : smileyId < 0");
        accountId = buf.readInt();
        if (accountId < 0)
            throw new RuntimeException("Forbidden value on accountId = " + accountId + ", it doesn't respect the following condition : accountId < 0");
    }
    
}
