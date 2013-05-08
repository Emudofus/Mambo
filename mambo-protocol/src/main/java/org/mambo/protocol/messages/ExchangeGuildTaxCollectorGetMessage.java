

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeString(collectorName);
        buf.writeShort(worldX);
        buf.writeShort(worldY);
        buf.writeInt(mapId);
        buf.writeShort(subAreaId);
        buf.writeString(userName);
        buf.writeDouble(experience);
        buf.writeUShort(objectsInfos.length);
        for (ObjectItemQuantity entry : objectsInfos) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        collectorName = buf.readString();
        worldX = buf.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = buf.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
        mapId = buf.readInt();
        subAreaId = buf.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
        userName = buf.readString();
        experience = buf.readDouble();
        int limit = buf.readUShort();
        objectsInfos = new ObjectItemQuantity[limit];
        for (int i = 0; i < limit; i++) {
            objectsInfos[i] = new ObjectItemQuantity();
            objectsInfos[i].deserialize(buf);
        }
    }
    
}
