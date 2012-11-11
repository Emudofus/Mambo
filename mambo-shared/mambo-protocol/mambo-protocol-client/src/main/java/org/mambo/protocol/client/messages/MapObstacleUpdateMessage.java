

// Generated on 11/11/2012 20:41:27
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class MapObstacleUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6051;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public MapObstacle[] obstacles;
    
    public MapObstacleUpdateMessage() { }
    
    public MapObstacleUpdateMessage(MapObstacle[] obstacles) {
        this.obstacles = obstacles;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(obstacles.length);
        for (MapObstacle entry : obstacles) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        obstacles = new MapObstacle[limit];
        for (int i = 0; i < limit; i++) {
            obstacles[i] = new MapObstacle();
            obstacles[i].deserialize(reader);
        }
    }
    
}
