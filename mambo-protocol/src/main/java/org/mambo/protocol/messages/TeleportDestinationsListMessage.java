

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TeleportDestinationsListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5960;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte teleporterType;
    public int[] mapIds;
    public short[] subAreaIds;
    public short[] costs;
    
    public TeleportDestinationsListMessage() { }
    
    public TeleportDestinationsListMessage(byte teleporterType, int[] mapIds, short[] subAreaIds, short[] costs) {
        this.teleporterType = teleporterType;
        this.mapIds = mapIds;
        this.subAreaIds = subAreaIds;
        this.costs = costs;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(teleporterType);
        buf.writeUShort(mapIds.length);
        for (int entry : mapIds) {
            buf.writeInt(entry);
        }
        buf.writeUShort(subAreaIds.length);
        for (short entry : subAreaIds) {
            buf.writeShort(entry);
        }
        buf.writeUShort(costs.length);
        for (short entry : costs) {
            buf.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        teleporterType = buf.readByte();
        if (teleporterType < 0)
            throw new RuntimeException("Forbidden value on teleporterType = " + teleporterType + ", it doesn't respect the following condition : teleporterType < 0");
        int limit = buf.readUShort();
        mapIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            mapIds[i] = buf.readInt();
        }
        limit = buf.readUShort();
        subAreaIds = new short[limit];
        for (int i = 0; i < limit; i++) {
            subAreaIds[i] = buf.readShort();
        }
        limit = buf.readUShort();
        costs = new short[limit];
        for (int i = 0; i < limit; i++) {
            costs[i] = buf.readShort();
        }
    }
    
}
