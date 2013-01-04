

// Generated on 01/04/2013 14:54:49
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PaddockInformationsForSell implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 222;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeString(guildOwner);
        writer.writeShort(worldX);
        writer.writeShort(worldY);
        writer.writeShort(subAreaId);
        writer.writeByte(nbMount);
        writer.writeByte(nbObject);
        writer.writeInt(price);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        guildOwner = reader.readString();
        worldX = reader.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = reader.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
        subAreaId = reader.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
        nbMount = reader.readByte();
        nbObject = reader.readByte();
        price = reader.readInt();
        if (price < 0)
            throw new RuntimeException("Forbidden value on price = " + price + ", it doesn't respect the following condition : price < 0");
    }
    
}
