

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class DisplayNumericalValueMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5808;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int entityId;
    public int value;
    public byte type;
    
    public DisplayNumericalValueMessage() { }
    
    public DisplayNumericalValueMessage(int entityId, int value, byte type) {
        this.entityId = entityId;
        this.value = value;
        this.type = type;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(entityId);
        buf.writeInt(value);
        buf.writeByte(type);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        entityId = buf.readInt();
        value = buf.readInt();
        type = buf.readByte();
        if (type < 0)
            throw new RuntimeException("Forbidden value on type = " + type + ", it doesn't respect the following condition : type < 0");
    }
    
}
