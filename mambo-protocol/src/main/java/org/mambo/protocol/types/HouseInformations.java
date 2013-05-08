

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class HouseInformations extends NetworkType {
    public static final short TYPE_ID = 111;
    
    @Override
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
    public void serialize(Buffer buf) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, isOnSale);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, isSaleLocked);
        buf.writeUByte(flag1);
        buf.writeInt(houseId);
        buf.writeUShort(doorsOnMap.length);
        for (int entry : doorsOnMap) {
            buf.writeInt(entry);
        }
        buf.writeString(ownerName);
        buf.writeShort(modelId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        short flag1 = buf.readUByte();
        isOnSale = BooleanByteWrapper.getFlag(flag1, 0);
        isSaleLocked = BooleanByteWrapper.getFlag(flag1, 1);
        houseId = buf.readInt();
        if (houseId < 0)
            throw new RuntimeException("Forbidden value on houseId = " + houseId + ", it doesn't respect the following condition : houseId < 0");
        int limit = buf.readUShort();
        doorsOnMap = new int[limit];
        for (int i = 0; i < limit; i++) {
            doorsOnMap[i] = buf.readInt();
        }
        ownerName = buf.readString();
        modelId = buf.readShort();
        if (modelId < 0)
            throw new RuntimeException("Forbidden value on modelId = " + modelId + ", it doesn't respect the following condition : modelId < 0");
    }
    
}
