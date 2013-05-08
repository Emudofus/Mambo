

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class UpdateMountBoostMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6179;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double rideId;
    public UpdateMountBoost[] boostToUpdateList;
    
    public UpdateMountBoostMessage() { }
    
    public UpdateMountBoostMessage(double rideId, UpdateMountBoost[] boostToUpdateList) {
        this.rideId = rideId;
        this.boostToUpdateList = boostToUpdateList;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeDouble(rideId);
        buf.writeUShort(boostToUpdateList.length);
        for (UpdateMountBoost entry : boostToUpdateList) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        rideId = buf.readDouble();
        int limit = buf.readUShort();
        boostToUpdateList = new UpdateMountBoost[limit];
        for (int i = 0; i < limit; i++) {
            boostToUpdateList[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            boostToUpdateList[i].deserialize(buf);
        }
    }
    
}
