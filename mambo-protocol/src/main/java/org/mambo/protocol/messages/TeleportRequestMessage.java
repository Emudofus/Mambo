

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TeleportRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5961;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte teleporterType;
    public int mapId;
    
    public TeleportRequestMessage() { }
    
    public TeleportRequestMessage(byte teleporterType, int mapId) {
        this.teleporterType = teleporterType;
        this.mapId = mapId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(teleporterType);
        buf.writeInt(mapId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        teleporterType = buf.readByte();
        if (teleporterType < 0)
            throw new RuntimeException("Forbidden value on teleporterType = " + teleporterType + ", it doesn't respect the following condition : teleporterType < 0");
        mapId = buf.readInt();
        if (mapId < 0)
            throw new RuntimeException("Forbidden value on mapId = " + mapId + ", it doesn't respect the following condition : mapId < 0");
    }
    
}
