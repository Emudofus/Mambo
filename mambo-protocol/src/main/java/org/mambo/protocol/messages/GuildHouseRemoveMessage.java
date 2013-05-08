

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildHouseRemoveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6180;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int houseId;
    
    public GuildHouseRemoveMessage() { }
    
    public GuildHouseRemoveMessage(int houseId) {
        this.houseId = houseId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(houseId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        houseId = buf.readInt();
        if (houseId < 0)
            throw new RuntimeException("Forbidden value on houseId = " + houseId + ", it doesn't respect the following condition : houseId < 0");
    }
    
}
