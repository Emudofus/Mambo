

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class TeleportRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5961;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte teleporterType;
    public int mapId;
    
    public TeleportRequestMessage() { }
    
    public TeleportRequestMessage(byte teleporterType, int mapId) {
        this.teleporterType = teleporterType;
        this.mapId = mapId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(teleporterType);
        writer.writeInt(mapId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        teleporterType = reader.readByte();
        if (teleporterType < 0)
            throw new RuntimeException("Forbidden value on teleporterType = " + teleporterType + ", it doesn't respect the following condition : teleporterType < 0");
        mapId = reader.readInt();
        if (mapId < 0)
            throw new RuntimeException("Forbidden value on mapId = " + mapId + ", it doesn't respect the following condition : mapId < 0");
    }
    
}
