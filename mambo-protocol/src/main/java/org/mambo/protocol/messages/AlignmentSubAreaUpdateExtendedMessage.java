

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AlignmentSubAreaUpdateExtendedMessage extends AlignmentSubAreaUpdateMessage {
    public static final int MESSAGE_ID = 6319;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short worldX;
    public short worldY;
    public int mapId;
    public byte eventType;
    
    public AlignmentSubAreaUpdateExtendedMessage() { }
    
    public AlignmentSubAreaUpdateExtendedMessage(short subAreaId, byte side, boolean quiet, short worldX, short worldY, int mapId, byte eventType) {
        super(subAreaId, side, quiet);
        this.worldX = worldX;
        this.worldY = worldY;
        this.mapId = mapId;
        this.eventType = eventType;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(worldX);
        buf.writeShort(worldY);
        buf.writeInt(mapId);
        buf.writeByte(eventType);
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
        mapId = buf.readInt();
        eventType = buf.readByte();
    }
    
}
