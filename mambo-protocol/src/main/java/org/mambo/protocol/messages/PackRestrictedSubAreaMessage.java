

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PackRestrictedSubAreaMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6186;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int subAreaId;
    
    public PackRestrictedSubAreaMessage() { }
    
    public PackRestrictedSubAreaMessage(int subAreaId) {
        this.subAreaId = subAreaId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(subAreaId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        subAreaId = buf.readInt();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
    }
    
}
