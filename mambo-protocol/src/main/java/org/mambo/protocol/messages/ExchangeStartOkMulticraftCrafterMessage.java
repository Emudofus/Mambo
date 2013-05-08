

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeStartOkMulticraftCrafterMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5818;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte maxCase;
    public int skillId;
    
    public ExchangeStartOkMulticraftCrafterMessage() { }
    
    public ExchangeStartOkMulticraftCrafterMessage(byte maxCase, int skillId) {
        this.maxCase = maxCase;
        this.skillId = skillId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(maxCase);
        buf.writeInt(skillId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        maxCase = buf.readByte();
        if (maxCase < 0)
            throw new RuntimeException("Forbidden value on maxCase = " + maxCase + ", it doesn't respect the following condition : maxCase < 0");
        skillId = buf.readInt();
        if (skillId < 0)
            throw new RuntimeException("Forbidden value on skillId = " + skillId + ", it doesn't respect the following condition : skillId < 0");
    }
    
}
