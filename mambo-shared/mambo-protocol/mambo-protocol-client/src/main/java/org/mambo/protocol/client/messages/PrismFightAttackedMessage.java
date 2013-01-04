

// Generated on 01/04/2013 14:54:40
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PrismFightAttackedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5894;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short worldX;
    public short worldY;
    public int mapId;
    public short subAreaId;
    public byte prismSide;
    
    public PrismFightAttackedMessage() { }
    
    public PrismFightAttackedMessage(short worldX, short worldY, int mapId, short subAreaId, byte prismSide) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.mapId = mapId;
        this.subAreaId = subAreaId;
        this.prismSide = prismSide;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(worldX);
        writer.writeShort(worldY);
        writer.writeInt(mapId);
        writer.writeShort(subAreaId);
        writer.writeByte(prismSide);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        worldX = reader.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = reader.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
        mapId = reader.readInt();
        subAreaId = reader.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
        prismSide = reader.readByte();
    }
    
}
