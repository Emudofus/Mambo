

// Generated on 11/11/2012 19:06:14
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class VillageConquestPrismInformation implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 379;
    
    
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
    public void serialize(DataWriterInterface writer) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, isEntered);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, isInRoom);
        writer.writeUnsignedByte(flag1);
        writer.writeShort(areaId);
        writer.writeByte(areaAlignment);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        short flag1 = reader.readUnsignedByte();
        isEntered = BooleanByteWrapper.getFlag(flag1, 0);
        isInRoom = BooleanByteWrapper.getFlag(flag1, 1);
        areaId = reader.readShort();
        if (areaId < 0)
            throw new RuntimeException("Forbidden value on areaId = " + areaId + ", it doesn't respect the following condition : areaId < 0");
        areaAlignment = reader.readByte();
        if (areaAlignment < 0)
            throw new RuntimeException("Forbidden value on areaAlignment = " + areaAlignment + ", it doesn't respect the following condition : areaAlignment < 0");
    }
    
}
