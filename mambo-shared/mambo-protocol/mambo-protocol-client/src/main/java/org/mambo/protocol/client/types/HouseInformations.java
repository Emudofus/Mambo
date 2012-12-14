

// Generated on 12/14/2012 18:44:23
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class HouseInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 111;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public boolean isOnSale;
    public boolean isSaleLocked;
    public int houseId;
    public int[] doorsOnMap;
    public String ownerName;
    public short modelId;
    
    public HouseInformations() { }
    
    public HouseInformations(boolean isOnSale, boolean isSaleLocked, int houseId, int[] doorsOnMap, String ownerName, short modelId) {
        this.isOnSale = isOnSale;
        this.isSaleLocked = isSaleLocked;
        this.houseId = houseId;
        this.doorsOnMap = doorsOnMap;
        this.ownerName = ownerName;
        this.modelId = modelId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, isOnSale);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, isSaleLocked);
        writer.writeUnsignedByte(flag1);
        writer.writeInt(houseId);
        writer.writeUnsignedShort(doorsOnMap.length);
        for (int entry : doorsOnMap) {
            writer.writeInt(entry);
        }
        writer.writeString(ownerName);
        writer.writeShort(modelId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        short flag1 = reader.readUnsignedByte();
        isOnSale = BooleanByteWrapper.getFlag(flag1, 0);
        isSaleLocked = BooleanByteWrapper.getFlag(flag1, 1);
        houseId = reader.readInt();
        if (houseId < 0)
            throw new RuntimeException("Forbidden value on houseId = " + houseId + ", it doesn't respect the following condition : houseId < 0");
        int limit = reader.readUnsignedShort();
        doorsOnMap = new int[limit];
        for (int i = 0; i < limit; i++) {
            doorsOnMap[i] = reader.readInt();
        }
        ownerName = reader.readString();
        modelId = reader.readShort();
        if (modelId < 0)
            throw new RuntimeException("Forbidden value on modelId = " + modelId + ", it doesn't respect the following condition : modelId < 0");
    }
    
}
