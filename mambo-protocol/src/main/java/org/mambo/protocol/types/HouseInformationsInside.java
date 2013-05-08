

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class HouseInformationsInside extends NetworkType {
    public static final short TYPE_ID = 218;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeInt(houseId);
        buf.writeShort(modelId);
        buf.writeInt(ownerId);
        buf.writeString(ownerName);
        buf.writeShort(worldX);
        buf.writeShort(worldY);
        buf.writeUInt(price);
        buf.writeBoolean(isLocked);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        houseId = buf.readInt();
        if (houseId < 0)
            throw new RuntimeException("Forbidden value on houseId = " + houseId + ", it doesn't respect the following condition : houseId < 0");
        modelId = buf.readShort();
        if (modelId < 0)
            throw new RuntimeException("Forbidden value on modelId = " + modelId + ", it doesn't respect the following condition : modelId < 0");
        ownerId = buf.readInt();
        ownerName = buf.readString();
        worldX = buf.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = buf.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
        price = buf.readUInt();
        if (price < 0 || price > 4294967295L)
            throw new RuntimeException("Forbidden value on price = " + price + ", it doesn't respect the following condition : price < 0 || price > 4294967295L");
        isLocked = buf.readBoolean();
    }
    
}
