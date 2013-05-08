

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class HouseInformationsForSell extends NetworkType {
    public static final short TYPE_ID = 221;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int modelId;
    public String ownerName;
    public boolean ownerConnected;
    public short worldX;
    public short worldY;
    public short subAreaId;
    public byte nbRoom;
    public byte nbChest;
    public int[] skillListIds;
    public boolean isLocked;
    public int price;
    
    public HouseInformationsForSell() { }
    
    public HouseInformationsForSell(int modelId, String ownerName, boolean ownerConnected, short worldX, short worldY, short subAreaId, byte nbRoom, byte nbChest, int[] skillListIds, boolean isLocked, int price) {
        this.modelId = modelId;
        this.ownerName = ownerName;
        this.ownerConnected = ownerConnected;
        this.worldX = worldX;
        this.worldY = worldY;
        this.subAreaId = subAreaId;
        this.nbRoom = nbRoom;
        this.nbChest = nbChest;
        this.skillListIds = skillListIds;
        this.isLocked = isLocked;
        this.price = price;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(modelId);
        buf.writeString(ownerName);
        buf.writeBoolean(ownerConnected);
        buf.writeShort(worldX);
        buf.writeShort(worldY);
        buf.writeShort(subAreaId);
        buf.writeByte(nbRoom);
        buf.writeByte(nbChest);
        buf.writeUShort(skillListIds.length);
        for (int entry : skillListIds) {
            buf.writeInt(entry);
        }
        buf.writeBoolean(isLocked);
        buf.writeInt(price);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        modelId = buf.readInt();
        if (modelId < 0)
            throw new RuntimeException("Forbidden value on modelId = " + modelId + ", it doesn't respect the following condition : modelId < 0");
        ownerName = buf.readString();
        ownerConnected = buf.readBoolean();
        worldX = buf.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = buf.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
        subAreaId = buf.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
        nbRoom = buf.readByte();
        nbChest = buf.readByte();
        int limit = buf.readUShort();
        skillListIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            skillListIds[i] = buf.readInt();
        }
        isLocked = buf.readBoolean();
        price = buf.readInt();
        if (price < 0)
            throw new RuntimeException("Forbidden value on price = " + price + ", it doesn't respect the following condition : price < 0");
    }
    
}
