

// Generated on 01/04/2013 14:54:48
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class HouseInformationsInside implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 218;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int houseId;
    public short modelId;
    public int ownerId;
    public String ownerName;
    public short worldX;
    public short worldY;
    public long price;
    public boolean isLocked;
    
    public HouseInformationsInside() { }
    
    public HouseInformationsInside(int houseId, short modelId, int ownerId, String ownerName, short worldX, short worldY, long price, boolean isLocked) {
        this.houseId = houseId;
        this.modelId = modelId;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.worldX = worldX;
        this.worldY = worldY;
        this.price = price;
        this.isLocked = isLocked;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(houseId);
        writer.writeShort(modelId);
        writer.writeInt(ownerId);
        writer.writeString(ownerName);
        writer.writeShort(worldX);
        writer.writeShort(worldY);
        writer.writeUnsignedInt(price);
        writer.writeBoolean(isLocked);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        houseId = reader.readInt();
        if (houseId < 0)
            throw new RuntimeException("Forbidden value on houseId = " + houseId + ", it doesn't respect the following condition : houseId < 0");
        modelId = reader.readShort();
        if (modelId < 0)
            throw new RuntimeException("Forbidden value on modelId = " + modelId + ", it doesn't respect the following condition : modelId < 0");
        ownerId = reader.readInt();
        ownerName = reader.readString();
        worldX = reader.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = reader.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
        price = reader.readUnsignedInt();
        if (price < 0 || price > 4294967295L)
            throw new RuntimeException("Forbidden value on price = " + price + ", it doesn't respect the following condition : price < 0 || price > 4294967295L");
        isLocked = reader.readBoolean();
    }
    
}
