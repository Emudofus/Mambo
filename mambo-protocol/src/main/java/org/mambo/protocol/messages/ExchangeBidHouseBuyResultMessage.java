

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeBidHouseBuyResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6272;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int uid;
    public boolean bought;
    
    public ExchangeBidHouseBuyResultMessage() { }
    
    public ExchangeBidHouseBuyResultMessage(int uid, boolean bought) {
        this.uid = uid;
        this.bought = bought;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(uid);
        buf.writeBoolean(bought);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        uid = buf.readInt();
        if (uid < 0)
            throw new RuntimeException("Forbidden value on uid = " + uid + ", it doesn't respect the following condition : uid < 0");
        bought = buf.readBoolean();
    }
    
}
