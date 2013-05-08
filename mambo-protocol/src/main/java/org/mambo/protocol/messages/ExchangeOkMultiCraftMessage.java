

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeOkMultiCraftMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5768;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int initiatorId;
    public int otherId;
    public byte role;
    
    public ExchangeOkMultiCraftMessage() { }
    
    public ExchangeOkMultiCraftMessage(int initiatorId, int otherId, byte role) {
        this.initiatorId = initiatorId;
        this.otherId = otherId;
        this.role = role;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(initiatorId);
        buf.writeInt(otherId);
        buf.writeByte(role);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        initiatorId = buf.readInt();
        if (initiatorId < 0)
            throw new RuntimeException("Forbidden value on initiatorId = " + initiatorId + ", it doesn't respect the following condition : initiatorId < 0");
        otherId = buf.readInt();
        if (otherId < 0)
            throw new RuntimeException("Forbidden value on otherId = " + otherId + ", it doesn't respect the following condition : otherId < 0");
        role = buf.readByte();
    }
    
}
