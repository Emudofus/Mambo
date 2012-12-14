

// Generated on 12/14/2012 18:44:23
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class HouseInformationsForSell implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 221;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(modelId);
        writer.writeString(ownerName);
        writer.writeBoolean(ownerConnected);
        writer.writeShort(worldX);
        writer.writeShort(worldY);
        writer.writeShort(subAreaId);
        writer.writeByte(nbRoom);
        writer.writeByte(nbChest);
        writer.writeUnsignedShort(skillListIds.length);
        for (int entry : skillListIds) {
            writer.writeInt(entry);
        }
        writer.writeBoolean(isLocked);
        writer.writeInt(price);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        modelId = reader.readInt();
        if (modelId < 0)
            throw new RuntimeException("Forbidden value on modelId = " + modelId + ", it doesn't respect the following condition : modelId < 0");
        ownerName = reader.readString();
        ownerConnected = reader.readBoolean();
        worldX = reader.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = reader.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
        subAreaId = reader.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
        nbRoom = reader.readByte();
        nbChest = reader.readByte();
        int limit = reader.readUnsignedShort();
        skillListIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            skillListIds[i] = reader.readInt();
        }
        isLocked = reader.readBoolean();
        price = reader.readInt();
        if (price < 0)
            throw new RuntimeException("Forbidden value on price = " + price + ", it doesn't respect the following condition : price < 0");
    }
    
}
