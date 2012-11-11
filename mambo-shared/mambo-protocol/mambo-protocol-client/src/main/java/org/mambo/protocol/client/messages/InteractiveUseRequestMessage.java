

// Generated on 11/11/2012 20:41:33
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class InteractiveUseRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5001;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int elemId;
    public int skillInstanceUid;
    
    public InteractiveUseRequestMessage() { }
    
    public InteractiveUseRequestMessage(int elemId, int skillInstanceUid) {
        this.elemId = elemId;
        this.skillInstanceUid = skillInstanceUid;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(elemId);
        writer.writeInt(skillInstanceUid);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        elemId = reader.readInt();
        if (elemId < 0)
            throw new RuntimeException("Forbidden value on elemId = " + elemId + ", it doesn't respect the following condition : elemId < 0");
        skillInstanceUid = reader.readInt();
        if (skillInstanceUid < 0)
            throw new RuntimeException("Forbidden value on skillInstanceUid = " + skillInstanceUid + ", it doesn't respect the following condition : skillInstanceUid < 0");
    }
    
}
