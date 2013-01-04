

// Generated on 01/04/2013 14:54:33
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class TaxCollectorAttackedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5918;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short firstNameId;
    public short lastNameId;
    public short worldX;
    public short worldY;
    public int mapId;
    public short subAreaId;
    
    public TaxCollectorAttackedMessage() { }
    
    public TaxCollectorAttackedMessage(short firstNameId, short lastNameId, short worldX, short worldY, int mapId, short subAreaId) {
        this.firstNameId = firstNameId;
        this.lastNameId = lastNameId;
        this.worldX = worldX;
        this.worldY = worldY;
        this.mapId = mapId;
        this.subAreaId = subAreaId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(firstNameId);
        writer.writeShort(lastNameId);
        writer.writeShort(worldX);
        writer.writeShort(worldY);
        writer.writeInt(mapId);
        writer.writeShort(subAreaId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        firstNameId = reader.readShort();
        if (firstNameId < 0)
            throw new RuntimeException("Forbidden value on firstNameId = " + firstNameId + ", it doesn't respect the following condition : firstNameId < 0");
        lastNameId = reader.readShort();
        if (lastNameId < 0)
            throw new RuntimeException("Forbidden value on lastNameId = " + lastNameId + ", it doesn't respect the following condition : lastNameId < 0");
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
    }
    
}
