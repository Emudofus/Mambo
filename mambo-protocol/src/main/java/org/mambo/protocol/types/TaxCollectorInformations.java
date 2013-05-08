

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TaxCollectorInformations extends NetworkType {
    public static final short TYPE_ID = 167;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeInt(uniqueId);
        buf.writeShort(firtNameId);
        buf.writeShort(lastNameId);
        additionalInfos.serialize(buf);
        buf.writeShort(worldX);
        buf.writeShort(worldY);
        buf.writeShort(subAreaId);
        buf.writeByte(state);
        look.serialize(buf);
        buf.writeInt(kamas);
        buf.writeDouble(experience);
        buf.writeInt(pods);
        buf.writeInt(itemsValue);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        uniqueId = buf.readInt();
        firtNameId = buf.readShort();
        if (firtNameId < 0)
            throw new RuntimeException("Forbidden value on firtNameId = " + firtNameId + ", it doesn't respect the following condition : firtNameId < 0");
        lastNameId = buf.readShort();
        if (lastNameId < 0)
            throw new RuntimeException("Forbidden value on lastNameId = " + lastNameId + ", it doesn't respect the following condition : lastNameId < 0");
        additionalInfos = new AdditionalTaxCollectorInformations();
        additionalInfos.deserialize(buf);
        worldX = buf.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = buf.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
        subAreaId = buf.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
        state = buf.readByte();
        look = new EntityLook();
        look.deserialize(buf);
        kamas = buf.readInt();
        if (kamas < 0)
            throw new RuntimeException("Forbidden value on kamas = " + kamas + ", it doesn't respect the following condition : kamas < 0");
        experience = buf.readDouble();
        if (experience < 0)
            throw new RuntimeException("Forbidden value on experience = " + experience + ", it doesn't respect the following condition : experience < 0");
        pods = buf.readInt();
        if (pods < 0)
            throw new RuntimeException("Forbidden value on pods = " + pods + ", it doesn't respect the following condition : pods < 0");
        itemsValue = buf.readInt();
        if (itemsValue < 0)
            throw new RuntimeException("Forbidden value on itemsValue = " + itemsValue + ", it doesn't respect the following condition : itemsValue < 0");
    }
    
}
