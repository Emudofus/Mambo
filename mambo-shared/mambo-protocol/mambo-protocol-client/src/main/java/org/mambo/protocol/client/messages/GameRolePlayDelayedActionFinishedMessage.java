

// Generated on 11/11/2012 20:41:27
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(delayedCharacterId);
        writer.writeByte(delayTypeId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        delayedCharacterId = reader.readInt();
        delayTypeId = reader.readByte();
        if (delayTypeId < 0)
            throw new RuntimeException("Forbidden value on delayTypeId = " + delayTypeId + ", it doesn't respect the following condition : delayTypeId < 0");
    }
    
}
