

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MapComplementaryInformationsDataMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 226;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short subAreaId;
    public int mapId;
    public byte subareaAlignmentSide;
    public HouseInformations[] houses;
    public GameRolePlayActorInformations[] actors;
    public InteractiveElement[] interactiveElements;
    public StatedElement[] statedElements;
    public MapObstacle[] obstacles;
    public FightCommonInformations[] fights;
    
    public MapComplementaryInformationsDataMessage() { }
    
    public MapComplementaryInformationsDataMessage(short subAreaId, int mapId, byte subareaAlignmentSide, HouseInformations[] houses, GameRolePlayActorInformations[] actors, InteractiveElement[] interactiveElements, StatedElement[] statedElements, MapObstacle[] obstacles, FightCommonInformations[] fights) {
        this.subAreaId = subAreaId;
        this.mapId = mapId;
        this.subareaAlignmentSide = subareaAlignmentSide;
        this.houses = houses;
        this.actors = actors;
        this.interactiveElements = interactiveElements;
        this.statedElements = statedElements;
        this.obstacles = obstacles;
        this.fights = fights;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(subAreaId);
        buf.writeInt(mapId);
        buf.writeByte(subareaAlignmentSide);
        buf.writeUShort(houses.length);
        for (HouseInformations entry : houses) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
        buf.writeUShort(actors.length);
        for (GameRolePlayActorInformations entry : actors) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
        buf.writeUShort(interactiveElements.length);
        for (InteractiveElement entry : interactiveElements) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
        buf.writeUShort(statedElements.length);
        for (StatedElement entry : statedElements) {
            entry.serialize(buf);
        }
        buf.writeUShort(obstacles.length);
        for (MapObstacle entry : obstacles) {
            entry.serialize(buf);
        }
        buf.writeUShort(fights.length);
        for (FightCommonInformations entry : fights) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        subAreaId = buf.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
        mapId = buf.readInt();
        if (mapId < 0)
            throw new RuntimeException("Forbidden value on mapId = " + mapId + ", it doesn't respect the following condition : mapId < 0");
        subareaAlignmentSide = buf.readByte();
        int limit = buf.readUShort();
        houses = new HouseInformations[limit];
        for (int i = 0; i < limit; i++) {
            houses[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            houses[i].deserialize(buf);
        }
        limit = buf.readUShort();
        actors = new GameRolePlayActorInformations[limit];
        for (int i = 0; i < limit; i++) {
            actors[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            actors[i].deserialize(buf);
        }
        limit = buf.readUShort();
        interactiveElements = new InteractiveElement[limit];
        for (int i = 0; i < limit; i++) {
            interactiveElements[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            interactiveElements[i].deserialize(buf);
        }
        limit = buf.readUShort();
        statedElements = new StatedElement[limit];
        for (int i = 0; i < limit; i++) {
            statedElements[i] = new StatedElement();
            statedElements[i].deserialize(buf);
        }
        limit = buf.readUShort();
        obstacles = new MapObstacle[limit];
        for (int i = 0; i < limit; i++) {
            obstacles[i] = new MapObstacle();
            obstacles[i].deserialize(buf);
        }
        limit = buf.readUShort();
        fights = new FightCommonInformations[limit];
        for (int i = 0; i < limit; i++) {
            fights[i] = new FightCommonInformations();
            fights[i].deserialize(buf);
        }
    }
    
}
