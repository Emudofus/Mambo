

// Generated on 12/14/2012 18:44:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(subAreaId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        subAreaId = reader.readInt();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
    }
    
}
