

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class IgnoredListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5674;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public IgnoredInformations[] ignoredList;
    
    public IgnoredListMessage() { }
    
    public IgnoredListMessage(IgnoredInformations[] ignoredList) {
        this.ignoredList = ignoredList;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(ignoredList.length);
        for (IgnoredInformations entry : ignoredList) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        ignoredList = new IgnoredInformations[limit];
        for (int i = 0; i < limit; i++) {
            ignoredList[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            ignoredList[i].deserialize(buf);
        }
    }
    
}
