

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeHandleMountStableMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5965;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte actionType;
    public int rideId;
    
    public ExchangeHandleMountStableMessage() { }
    
    public ExchangeHandleMountStableMessage(byte actionType, int rideId) {
        this.actionType = actionType;
        this.rideId = rideId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(actionType);
        writer.writeInt(rideId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        actionType = reader.readByte();
        rideId = reader.readInt();
        if (rideId < 0)
            throw new RuntimeException("Forbidden value on rideId = " + rideId + ", it doesn't respect the following condition : rideId < 0");
    }
    
}
