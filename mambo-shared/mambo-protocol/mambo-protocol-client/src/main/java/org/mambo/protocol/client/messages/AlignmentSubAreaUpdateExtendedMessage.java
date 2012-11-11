

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class AlignmentSubAreaUpdateExtendedMessage extends AlignmentSubAreaUpdateMessage {
    public static final int MESSAGE_ID = 6319;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short worldX;
    public short worldY;
    public int mapId;
    public byte eventType;
    
    public AlignmentSubAreaUpdateExtendedMessage() { }
    
    public AlignmentSubAreaUpdateExtendedMessage(short subAreaId, byte side, boolean quiet, short worldX, short worldY, int mapId, byte eventType) {
        super(subAreaId, side, quiet);
        this.worldX = worldX;
        this.worldY = worldY;
        this.mapId = mapId;
        this.eventType = eventType;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(worldX);
        writer.writeShort(worldY);
        writer.writeInt(mapId);
        writer.writeByte(eventType);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        worldX = reader.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = reader.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
        mapId = reader.readInt();
        eventType = reader.readByte();
    }
    
}
