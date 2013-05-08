

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class NotificationListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6087;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] flags;
    
    public NotificationListMessage() { }
    
    public NotificationListMessage(int[] flags) {
        this.flags = flags;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(flags.length);
        for (int entry : flags) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        flags = new int[limit];
        for (int i = 0; i < limit; i++) {
            flags[i] = buf.readInt();
        }
    }
    
}
