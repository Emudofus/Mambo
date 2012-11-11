

// Generated on 11/11/2012 19:17:02
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        currentHouse.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        currentHouse = new HouseInformationsInside();
        currentHouse.deserialize(reader);
    }
    
}
