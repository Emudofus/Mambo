

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(ignoredList.length);
        for (IgnoredInformations entry : ignoredList) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        ignoredList = new IgnoredInformations[limit];
        for (int i = 0; i < limit; i++) {
            ignoredList[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), IgnoredInformations.class);
            ignoredList[i].deserialize(reader);
        }
    }
    
}
