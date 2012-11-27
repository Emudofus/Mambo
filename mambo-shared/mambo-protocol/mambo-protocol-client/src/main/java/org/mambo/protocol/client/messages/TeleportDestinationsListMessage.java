

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(teleporterType);
        writer.writeUnsignedShort(mapIds.length);
        for (int entry : mapIds) {
            writer.writeInt(entry);
        }
        writer.writeUnsignedShort(subAreaIds.length);
        for (short entry : subAreaIds) {
            writer.writeShort(entry);
        }
        writer.writeUnsignedShort(costs.length);
        for (short entry : costs) {
            writer.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        teleporterType = reader.readByte();
        if (teleporterType < 0)
            throw new RuntimeException("Forbidden value on teleporterType = " + teleporterType + ", it doesn't respect the following condition : teleporterType < 0");
        int limit = reader.readUnsignedShort();
        mapIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            mapIds[i] = reader.readInt();
        }
        limit = reader.readUnsignedShort();
        subAreaIds = new short[limit];
        for (int i = 0; i < limit; i++) {
            subAreaIds[i] = reader.readShort();
        }
        limit = reader.readUnsignedShort();
        costs = new short[limit];
        for (int i = 0; i < limit; i++) {
            costs[i] = reader.readShort();
        }
    }
    
}
