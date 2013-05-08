

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ChangeMapMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 221;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int mapId;
    
    public ChangeMapMessage() { }
    
    public ChangeMapMessage(int mapId) {
        this.mapId = mapId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(mapId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        mapId = buf.readInt();
        if (mapId < 0)
            throw new RuntimeException("Forbidden value on mapId = " + mapId + ", it doesn't respect the following condition : mapId < 0");
    }
    
}
