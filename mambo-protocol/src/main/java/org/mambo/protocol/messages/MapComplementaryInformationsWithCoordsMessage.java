

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MapComplementaryInformationsWithCoordsMessage extends MapComplementaryInformationsDataMessage {
    public static final int MESSAGE_ID = 6268;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short worldX;
    public short worldY;
    
    public MapComplementaryInformationsWithCoordsMessage() { }
    
    public MapComplementaryInformationsWithCoordsMessage(short subAreaId, int mapId, byte subareaAlignmentSide, HouseInformations[] houses, GameRolePlayActorInformations[] actors, InteractiveElement[] interactiveElements, StatedElement[] statedElements, MapObstacle[] obstacles, FightCommonInformations[] fights, short worldX, short worldY) {
        super(subAreaId, mapId, subareaAlignmentSide, houses, actors, interactiveElements, statedElements, obstacles, fights);
        this.worldX = worldX;
        this.worldY = worldY;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(worldX);
        buf.writeShort(worldY);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        worldX = buf.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = buf.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
    }
    
}
