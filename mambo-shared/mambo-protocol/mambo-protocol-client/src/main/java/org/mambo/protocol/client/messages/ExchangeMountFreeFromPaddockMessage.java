

// Generated on 01/04/2013 14:54:35
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeMountFreeFromPaddockMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6055;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String name;
    public short worldX;
    public short worldY;
    public String liberator;
    
    public ExchangeMountFreeFromPaddockMessage() { }
    
    public ExchangeMountFreeFromPaddockMessage(String name, short worldX, short worldY, String liberator) {
        this.name = name;
        this.worldX = worldX;
        this.worldY = worldY;
        this.liberator = liberator;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(name);
        writer.writeShort(worldX);
        writer.writeShort(worldY);
        writer.writeString(liberator);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        name = reader.readString();
        worldX = reader.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = reader.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
        liberator = reader.readString();
    }
    
}
