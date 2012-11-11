

// Generated on 11/11/2012 19:17:10
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeDouble(rideId);
        writer.writeUnsignedShort(boostToUpdateList.length);
        for (UpdateMountBoost entry : boostToUpdateList) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        rideId = reader.readDouble();
        int limit = reader.readUnsignedShort();
        boostToUpdateList = new UpdateMountBoost[limit];
        for (int i = 0; i < limit; i++) {
            boostToUpdateList[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), UpdateMountBoost.class);
            boostToUpdateList[i].deserialize(reader);
        }
    }
    
}
