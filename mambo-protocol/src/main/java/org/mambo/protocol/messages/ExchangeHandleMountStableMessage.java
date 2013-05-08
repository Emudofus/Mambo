

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeByte(actionType);
        buf.writeInt(rideId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        actionType = buf.readByte();
        rideId = buf.readInt();
        if (rideId < 0)
            throw new RuntimeException("Forbidden value on rideId = " + rideId + ", it doesn't respect the following condition : rideId < 0");
    }
    
}
