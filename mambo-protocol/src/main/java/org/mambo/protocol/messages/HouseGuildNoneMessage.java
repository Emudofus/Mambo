

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class HouseGuildNoneMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5701;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short houseId;
    
    public HouseGuildNoneMessage() { }
    
    public HouseGuildNoneMessage(short houseId) {
        this.houseId = houseId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(houseId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        houseId = buf.readShort();
        if (houseId < 0)
            throw new RuntimeException("Forbidden value on houseId = " + houseId + ", it doesn't respect the following condition : houseId < 0");
    }
    
}
