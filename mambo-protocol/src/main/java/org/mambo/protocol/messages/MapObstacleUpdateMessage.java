

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeUShort(obstacles.length);
        for (MapObstacle entry : obstacles) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        obstacles = new MapObstacle[limit];
        for (int i = 0; i < limit; i++) {
            obstacles[i] = new MapObstacle();
            obstacles[i].deserialize(buf);
        }
    }
    
}
