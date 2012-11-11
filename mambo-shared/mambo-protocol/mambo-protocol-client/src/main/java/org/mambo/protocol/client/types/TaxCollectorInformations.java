

// Generated on 11/11/2012 19:06:14
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class TaxCollectorInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 167;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int uniqueId;
    public short firtNameId;
    public short lastNameId;
    public AdditionalTaxCollectorInformations additionalInfos;
    public short worldX;
    public short worldY;
    public short subAreaId;
    public byte state;
    public EntityLook look;
    public int kamas;
    public double experience;
    public int pods;
    public int itemsValue;
    
    public TaxCollectorInformations() { }
    
    public TaxCollectorInformations(int uniqueId, short firtNameId, short lastNameId, AdditionalTaxCollectorInformations additionalInfos, short worldX, short worldY, short subAreaId, byte state, EntityLook look, int kamas, double experience, int pods, int itemsValue) {
        this.uniqueId = uniqueId;
        this.firtNameId = firtNameId;
        this.lastNameId = lastNameId;
        this.additionalInfos = additionalInfos;
        this.worldX = worldX;
        this.worldY = worldY;
        this.subAreaId = subAreaId;
        this.state = state;
        this.look = look;
        this.kamas = kamas;
        this.experience = experience;
        this.pods = pods;
        this.itemsValue = itemsValue;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(uniqueId);
        writer.writeShort(firtNameId);
        writer.writeShort(lastNameId);
        additionalInfos.serialize(writer);
        writer.writeShort(worldX);
        writer.writeShort(worldY);
        writer.writeShort(subAreaId);
        writer.writeByte(state);
        look.serialize(writer);
        writer.writeInt(kamas);
        writer.writeDouble(experience);
        writer.writeInt(pods);
        writer.writeInt(itemsValue);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        uniqueId = reader.readInt();
        firtNameId = reader.readShort();
        if (firtNameId < 0)
            throw new RuntimeException("Forbidden value on firtNameId = " + firtNameId + ", it doesn't respect the following condition : firtNameId < 0");
        lastNameId = reader.readShort();
        if (lastNameId < 0)
            throw new RuntimeException("Forbidden value on lastNameId = " + lastNameId + ", it doesn't respect the following condition : lastNameId < 0");
        additionalInfos = new AdditionalTaxCollectorInformations();
        additionalInfos.deserialize(reader);
        worldX = reader.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = reader.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
        subAreaId = reader.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
        state = reader.readByte();
        look = new EntityLook();
        look.deserialize(reader);
        kamas = reader.readInt();
        if (kamas < 0)
            throw new RuntimeException("Forbidden value on kamas = " + kamas + ", it doesn't respect the following condition : kamas < 0");
        experience = reader.readDouble();
        if (experience < 0)
            throw new RuntimeException("Forbidden value on experience = " + experience + ", it doesn't respect the following condition : experience < 0");
        pods = reader.readInt();
        if (pods < 0)
            throw new RuntimeException("Forbidden value on pods = " + pods + ", it doesn't respect the following condition : pods < 0");
        itemsValue = reader.readInt();
        if (itemsValue < 0)
            throw new RuntimeException("Forbidden value on itemsValue = " + itemsValue + ", it doesn't respect the following condition : itemsValue < 0");
    }
    
}
