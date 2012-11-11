

// Generated on 11/11/2012 20:41:33
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class InteractiveUsedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5745;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int entityId;
    public int elemId;
    public short skillId;
    public short duration;
    
    public InteractiveUsedMessage() { }
    
    public InteractiveUsedMessage(int entityId, int elemId, short skillId, short duration) {
        this.entityId = entityId;
        this.elemId = elemId;
        this.skillId = skillId;
        this.duration = duration;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(entityId);
        writer.writeInt(elemId);
        writer.writeShort(skillId);
        writer.writeShort(duration);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        entityId = reader.readInt();
        if (entityId < 0)
            throw new RuntimeException("Forbidden value on entityId = " + entityId + ", it doesn't respect the following condition : entityId < 0");
        elemId = reader.readInt();
        if (elemId < 0)
            throw new RuntimeException("Forbidden value on elemId = " + elemId + ", it doesn't respect the following condition : elemId < 0");
        skillId = reader.readShort();
        if (skillId < 0)
            throw new RuntimeException("Forbidden value on skillId = " + skillId + ", it doesn't respect the following condition : skillId < 0");
        duration = reader.readShort();
        if (duration < 0)
            throw new RuntimeException("Forbidden value on duration = " + duration + ", it doesn't respect the following condition : duration < 0");
    }
    
}
