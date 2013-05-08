

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class LockableStateUpdateHouseDoorMessage extends LockableStateUpdateAbstractMessage {
    public static final int MESSAGE_ID = 5668;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int houseId;
    
    public LockableStateUpdateHouseDoorMessage() { }
    
    public LockableStateUpdateHouseDoorMessage(boolean locked, int houseId) {
        super(locked);
        this.houseId = houseId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(houseId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        houseId = buf.readInt();
    }
    
}
