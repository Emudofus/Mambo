

// Generated on 11/11/2012 19:17:02
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(flags.length);
        for (int entry : flags) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        flags = new int[limit];
        for (int i = 0; i < limit; i++) {
            flags[i] = reader.readInt();
        }
    }
    
}
