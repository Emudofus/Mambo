

// Generated on 11/11/2012 19:17:02
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(subAreaId);
        writer.writeInt(mapId);
        writer.writeByte(subareaAlignmentSide);
        writer.writeUnsignedShort(houses.length);
        for (HouseInformations entry : houses) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(actors.length);
        for (GameRolePlayActorInformations entry : actors) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(interactiveElements.length);
        for (InteractiveElement entry : interactiveElements) {
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(statedElements.length);
        for (StatedElement entry : statedElements) {
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(obstacles.length);
        for (MapObstacle entry : obstacles) {
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(fights.length);
        for (FightCommonInformations entry : fights) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        subAreaId = reader.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
        mapId = reader.readInt();
        if (mapId < 0)
            throw new RuntimeException("Forbidden value on mapId = " + mapId + ", it doesn't respect the following condition : mapId < 0");
        subareaAlignmentSide = reader.readByte();
        int limit = reader.readUnsignedShort();
        houses = new HouseInformations[limit];
        for (int i = 0; i < limit; i++) {
            houses[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), HouseInformations.class);
            houses[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        actors = new GameRolePlayActorInformations[limit];
        for (int i = 0; i < limit; i++) {
            actors[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), GameRolePlayActorInformations.class);
            actors[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        interactiveElements = new InteractiveElement[limit];
        for (int i = 0; i < limit; i++) {
            interactiveElements[i] = new InteractiveElement();
            interactiveElements[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        statedElements = new StatedElement[limit];
        for (int i = 0; i < limit; i++) {
            statedElements[i] = new StatedElement();
            statedElements[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        obstacles = new MapObstacle[limit];
        for (int i = 0; i < limit; i++) {
            obstacles[i] = new MapObstacle();
            obstacles[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        fights = new FightCommonInformations[limit];
        for (int i = 0; i < limit; i++) {
            fights[i] = new FightCommonInformations();
            fights[i].deserialize(reader);
        }
    }
    
}
