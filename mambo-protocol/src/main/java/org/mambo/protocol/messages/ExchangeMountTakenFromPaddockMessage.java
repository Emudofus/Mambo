

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeMountTakenFromPaddockMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5994;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String name;
    public short worldX;
    public short worldY;
    public String ownername;
    
    public ExchangeMountTakenFromPaddockMessage() { }
    
    public ExchangeMountTakenFromPaddockMessage(String name, short worldX, short worldY, String ownername) {
        this.name = name;
        this.worldX = worldX;
        this.worldY = worldY;
        this.ownername = ownername;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(name);
        buf.writeShort(worldX);
        buf.writeShort(worldY);
        buf.writeString(ownername);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        name = buf.readString();
        worldX = buf.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = buf.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
        ownername = buf.readString();
    }
    
}
