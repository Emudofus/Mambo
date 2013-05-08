

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayDelayedActionMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6153;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int delayedCharacterId;
    public byte delayTypeId;
    public int delayDuration;
    
    public GameRolePlayDelayedActionMessage() { }
    
    public GameRolePlayDelayedActionMessage(int delayedCharacterId, byte delayTypeId, int delayDuration) {
        this.delayedCharacterId = delayedCharacterId;
        this.delayTypeId = delayTypeId;
        this.delayDuration = delayDuration;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(delayedCharacterId);
        buf.writeByte(delayTypeId);
        buf.writeInt(delayDuration);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        delayedCharacterId = buf.readInt();
        delayTypeId = buf.readByte();
        if (delayTypeId < 0)
            throw new RuntimeException("Forbidden value on delayTypeId = " + delayTypeId + ", it doesn't respect the following condition : delayTypeId < 0");
        delayDuration = buf.readInt();
        if (delayDuration < 0)
            throw new RuntimeException("Forbidden value on delayDuration = " + delayDuration + ", it doesn't respect the following condition : delayDuration < 0");
    }
    
}
