

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PaddockInformationsForSell extends NetworkType {
    public static final short TYPE_ID = 222;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public String guildOwner;
    public short worldX;
    public short worldY;
    public short subAreaId;
    public byte nbMount;
    public byte nbObject;
    public int price;
    
    public PaddockInformationsForSell() { }
    
    public PaddockInformationsForSell(String guildOwner, short worldX, short worldY, short subAreaId, byte nbMount, byte nbObject, int price) {
        this.guildOwner = guildOwner;
        this.worldX = worldX;
        this.worldY = worldY;
        this.subAreaId = subAreaId;
        this.nbMount = nbMount;
        this.nbObject = nbObject;
        this.price = price;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(guildOwner);
        buf.writeShort(worldX);
        buf.writeShort(worldY);
        buf.writeShort(subAreaId);
        buf.writeByte(nbMount);
        buf.writeByte(nbObject);
        buf.writeInt(price);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        guildOwner = buf.readString();
        worldX = buf.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = buf.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
        subAreaId = buf.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
        nbMount = buf.readByte();
        nbObject = buf.readByte();
        price = buf.readInt();
        if (price < 0)
            throw new RuntimeException("Forbidden value on price = " + price + ", it doesn't respect the following condition : price < 0");
    }
    
}
