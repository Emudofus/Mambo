

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangePlayerMultiCraftRequestMessage extends ExchangeRequestMessage {
    public static final int MESSAGE_ID = 5784;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int target;
    public int skillId;
    
    public ExchangePlayerMultiCraftRequestMessage() { }
    
    public ExchangePlayerMultiCraftRequestMessage(byte exchangeType, int target, int skillId) {
        super(exchangeType);
        this.target = target;
        this.skillId = skillId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(target);
        buf.writeInt(skillId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        target = buf.readInt();
        if (target < 0)
            throw new RuntimeException("Forbidden value on target = " + target + ", it doesn't respect the following condition : target < 0");
        skillId = buf.readInt();
        if (skillId < 0)
            throw new RuntimeException("Forbidden value on skillId = " + skillId + ", it doesn't respect the following condition : skillId < 0");
    }
    
}
