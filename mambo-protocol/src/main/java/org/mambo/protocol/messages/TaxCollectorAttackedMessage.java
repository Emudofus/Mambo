

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TaxCollectorAttackedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5918;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short firstNameId;
    public short lastNameId;
    public short worldX;
    public short worldY;
    public int mapId;
    public short subAreaId;
    
    public TaxCollectorAttackedMessage() { }
    
    public TaxCollectorAttackedMessage(short firstNameId, short lastNameId, short worldX, short worldY, int mapId, short subAreaId) {
        this.firstNameId = firstNameId;
        this.lastNameId = lastNameId;
        this.worldX = worldX;
        this.worldY = worldY;
        this.mapId = mapId;
        this.subAreaId = subAreaId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(firstNameId);
        buf.writeShort(lastNameId);
        buf.writeShort(worldX);
        buf.writeShort(worldY);
        buf.writeInt(mapId);
        buf.writeShort(subAreaId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        firstNameId = buf.readShort();
        if (firstNameId < 0)
            throw new RuntimeException("Forbidden value on firstNameId = " + firstNameId + ", it doesn't respect the following condition : firstNameId < 0");
        lastNameId = buf.readShort();
        if (lastNameId < 0)
            throw new RuntimeException("Forbidden value on lastNameId = " + lastNameId + ", it doesn't respect the following condition : lastNameId < 0");
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
    }
    
}
