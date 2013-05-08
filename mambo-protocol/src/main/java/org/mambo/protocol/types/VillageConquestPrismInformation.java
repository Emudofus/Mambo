

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class VillageConquestPrismInformation extends NetworkType {
    public static final short TYPE_ID = 379;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public boolean isEntered;
    public boolean isInRoom;
    public short areaId;
    public byte areaAlignment;
    
    public VillageConquestPrismInformation() { }
    
    public VillageConquestPrismInformation(boolean isEntered, boolean isInRoom, short areaId, byte areaAlignment) {
        this.isEntered = isEntered;
        this.isInRoom = isInRoom;
        this.areaId = areaId;
        this.areaAlignment = areaAlignment;
    }
    
    @Override
    public void serialize(Buffer buf) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, isEntered);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, isInRoom);
        buf.writeUByte(flag1);
        buf.writeShort(areaId);
        buf.writeByte(areaAlignment);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        short flag1 = buf.readUByte();
        isEntered = BooleanByteWrapper.getFlag(flag1, 0);
        isInRoom = BooleanByteWrapper.getFlag(flag1, 1);
        areaId = buf.readShort();
        if (areaId < 0)
            throw new RuntimeException("Forbidden value on areaId = " + areaId + ", it doesn't respect the following condition : areaId < 0");
        areaAlignment = buf.readByte();
        if (areaAlignment < 0)
            throw new RuntimeException("Forbidden value on areaAlignment = " + areaAlignment + ", it doesn't respect the following condition : areaAlignment < 0");
    }
    
}
