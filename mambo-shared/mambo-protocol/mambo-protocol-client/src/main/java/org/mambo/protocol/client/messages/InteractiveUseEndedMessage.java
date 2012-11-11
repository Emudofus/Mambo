

// Generated on 11/11/2012 20:41:33
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class InteractiveUseEndedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6112;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int elemId;
    public short skillId;
    
    public InteractiveUseEndedMessage() { }
    
    public InteractiveUseEndedMessage(int elemId, short skillId) {
        this.elemId = elemId;
        this.skillId = skillId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(elemId);
        writer.writeShort(skillId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        elemId = reader.readInt();
        if (elemId < 0)
            throw new RuntimeException("Forbidden value on elemId = " + elemId + ", it doesn't respect the following condition : elemId < 0");
        skillId = reader.readShort();
        if (skillId < 0)
            throw new RuntimeException("Forbidden value on skillId = " + skillId + ", it doesn't respect the following condition : skillId < 0");
    }
    
}
