

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MapComplementaryInformationsDataInHouseMessage extends MapComplementaryInformationsDataMessage {
    public static final int MESSAGE_ID = 6130;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public HouseInformationsInside currentHouse;
    
    public MapComplementaryInformationsDataInHouseMessage() { }
    
    public MapComplementaryInformationsDataInHouseMessage(short subAreaId, int mapId, byte subareaAlignmentSide, HouseInformations[] houses, GameRolePlayActorInformations[] actors, InteractiveElement[] interactiveElements, StatedElement[] statedElements, MapObstacle[] obstacles, FightCommonInformations[] fights, HouseInformationsInside currentHouse) {
        super(subAreaId, mapId, subareaAlignmentSide, houses, actors, interactiveElements, statedElements, obstacles, fights);
        this.currentHouse = currentHouse;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        currentHouse.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        currentHouse = new HouseInformationsInside();
        currentHouse.deserialize(buf);
    }
    
}
