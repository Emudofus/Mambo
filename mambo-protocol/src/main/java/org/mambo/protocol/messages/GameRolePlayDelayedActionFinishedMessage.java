

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayDelayedActionFinishedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6150;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int delayedCharacterId;
    public byte delayTypeId;
    
    public GameRolePlayDelayedActionFinishedMessage() { }
    
    public GameRolePlayDelayedActionFinishedMessage(int delayedCharacterId, byte delayTypeId) {
        this.delayedCharacterId = delayedCharacterId;
        this.delayTypeId = delayTypeId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(delayedCharacterId);
        buf.writeByte(delayTypeId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        delayedCharacterId = buf.readInt();
        delayTypeId = buf.readByte();
        if (delayTypeId < 0)
            throw new RuntimeException("Forbidden value on delayTypeId = " + delayTypeId + ", it doesn't respect the following condition : delayTypeId < 0");
    }
    
}
