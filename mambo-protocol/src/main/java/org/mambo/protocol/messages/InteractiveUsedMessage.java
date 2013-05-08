

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeInt(entityId);
        buf.writeInt(elemId);
        buf.writeShort(skillId);
        buf.writeShort(duration);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        entityId = buf.readInt();
        if (entityId < 0)
            throw new RuntimeException("Forbidden value on entityId = " + entityId + ", it doesn't respect the following condition : entityId < 0");
        elemId = buf.readInt();
        if (elemId < 0)
            throw new RuntimeException("Forbidden value on elemId = " + elemId + ", it doesn't respect the following condition : elemId < 0");
        skillId = buf.readShort();
        if (skillId < 0)
            throw new RuntimeException("Forbidden value on skillId = " + skillId + ", it doesn't respect the following condition : skillId < 0");
        duration = buf.readShort();
        if (duration < 0)
            throw new RuntimeException("Forbidden value on duration = " + duration + ", it doesn't respect the following condition : duration < 0");
    }
    
}
