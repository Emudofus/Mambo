

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class HouseGuildShareRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5704;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean enable;
    public long rights;
    
    public HouseGuildShareRequestMessage() { }
    
    public HouseGuildShareRequestMessage(boolean enable, long rights) {
        this.enable = enable;
        this.rights = rights;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(enable);
        buf.writeUInt(rights);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        enable = buf.readBoolean();
        rights = buf.readUInt();
        if (rights < 0 || rights > 4294967295L)
            throw new RuntimeException("Forbidden value on rights = " + rights + ", it doesn't respect the following condition : rights < 0 || rights > 4294967295L");
    }
    
}
