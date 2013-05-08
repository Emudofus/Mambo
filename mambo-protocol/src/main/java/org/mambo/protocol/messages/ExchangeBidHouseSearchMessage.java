

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeBidHouseSearchMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5806;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int type;
    public int genId;
    
    public ExchangeBidHouseSearchMessage() { }
    
    public ExchangeBidHouseSearchMessage(int type, int genId) {
        this.type = type;
        this.genId = genId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(type);
        buf.writeInt(genId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        type = buf.readInt();
        if (type < 0)
            throw new RuntimeException("Forbidden value on type = " + type + ", it doesn't respect the following condition : type < 0");
        genId = buf.readInt();
        if (genId < 0)
            throw new RuntimeException("Forbidden value on genId = " + genId + ", it doesn't respect the following condition : genId < 0");
    }
    
}
