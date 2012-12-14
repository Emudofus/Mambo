

// Generated on 12/14/2012 18:44:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(type);
        writer.writeShort(worldX);
        writer.writeShort(worldY);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        type = reader.readByte();
        if (type < 0)
            throw new RuntimeException("Forbidden value on type = " + type + ", it doesn't respect the following condition : type < 0");
        worldX = reader.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = reader.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
    }
    
}
