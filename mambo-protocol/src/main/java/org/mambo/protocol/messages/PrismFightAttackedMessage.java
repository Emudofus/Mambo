

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PrismFightAttackedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5894;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short worldX;
    public short worldY;
    public int mapId;
    public short subAreaId;
    public byte prismSide;
    
    public PrismFightAttackedMessage() { }
    
    public PrismFightAttackedMessage(short worldX, short worldY, int mapId, short subAreaId, byte prismSide) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.mapId = mapId;
        this.subAreaId = subAreaId;
        this.prismSide = prismSide;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(worldX);
        buf.writeShort(worldY);
        buf.writeInt(mapId);
        buf.writeShort(subAreaId);
        buf.writeByte(prismSide);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        worldX = buf.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = buf.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
        mapId = buf.readInt();
        subAreaId = buf.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
        prismSide = buf.readByte();
    }
    
}
