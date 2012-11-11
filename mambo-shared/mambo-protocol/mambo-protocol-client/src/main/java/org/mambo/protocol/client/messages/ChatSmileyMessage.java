

// Generated on 11/11/2012 19:17:00
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(entityId);
        writer.writeByte(smileyId);
        writer.writeInt(accountId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        entityId = reader.readInt();
        smileyId = reader.readByte();
        if (smileyId < 0)
            throw new RuntimeException("Forbidden value on smileyId = " + smileyId + ", it doesn't respect the following condition : smileyId < 0");
        accountId = reader.readInt();
        if (accountId < 0)
            throw new RuntimeException("Forbidden value on accountId = " + accountId + ", it doesn't respect the following condition : accountId < 0");
    }
    
}
