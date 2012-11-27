

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeGuildTaxCollectorGetMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5762;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String collectorName;
    public short worldX;
    public short worldY;
    public int mapId;
    public short subAreaId;
    public String userName;
    public double experience;
    public ObjectItemQuantity[] objectsInfos;
    
    public ExchangeGuildTaxCollectorGetMessage() { }
    
    public ExchangeGuildTaxCollectorGetMessage(String collectorName, short worldX, short worldY, int mapId, short subAreaId, String userName, double experience, ObjectItemQuantity[] objectsInfos) {
        this.collectorName = collectorName;
        this.worldX = worldX;
        this.worldY = worldY;
        this.mapId = mapId;
        this.subAreaId = subAreaId;
        this.userName = userName;
        this.experience = experience;
        this.objectsInfos = objectsInfos;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(collectorName);
        writer.writeShort(worldX);
        writer.writeShort(worldY);
        writer.writeInt(mapId);
        writer.writeShort(subAreaId);
        writer.writeString(userName);
        writer.writeDouble(experience);
        writer.writeUnsignedShort(objectsInfos.length);
        for (ObjectItemQuantity entry : objectsInfos) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        collectorName = reader.readString();
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
        userName = reader.readString();
        experience = reader.readDouble();
        int limit = reader.readUnsignedShort();
        objectsInfos = new ObjectItemQuantity[limit];
        for (int i = 0; i < limit; i++) {
            objectsInfos[i] = new ObjectItemQuantity();
            objectsInfos[i].deserialize(reader);
        }
    }
    
}
