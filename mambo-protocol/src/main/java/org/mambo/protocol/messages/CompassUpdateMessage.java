

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CompassUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5591;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte type;
    public short worldX;
    public short worldY;
    
    public CompassUpdateMessage() { }
    
    public CompassUpdateMessage(byte type, short worldX, short worldY) {
        this.type = type;
        this.worldX = worldX;
        this.worldY = worldY;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(type);
        buf.writeShort(worldX);
        buf.writeShort(worldY);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        type = buf.readByte();
        if (type < 0)
            throw new RuntimeException("Forbidden value on type = " + type + ", it doesn't respect the following condition : type < 0");
        worldX = buf.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = buf.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
    }
    
}
