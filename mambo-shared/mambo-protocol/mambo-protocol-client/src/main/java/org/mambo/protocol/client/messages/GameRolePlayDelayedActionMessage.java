

// Generated on 11/11/2012 20:41:27
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(delayedCharacterId);
        writer.writeByte(delayTypeId);
        writer.writeInt(delayDuration);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        delayedCharacterId = reader.readInt();
        delayTypeId = reader.readByte();
        if (delayTypeId < 0)
            throw new RuntimeException("Forbidden value on delayTypeId = " + delayTypeId + ", it doesn't respect the following condition : delayTypeId < 0");
        delayDuration = reader.readInt();
        if (delayDuration < 0)
            throw new RuntimeException("Forbidden value on delayDuration = " + delayDuration + ", it doesn't respect the following condition : delayDuration < 0");
    }
    
}
