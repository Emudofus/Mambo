

// Generated on 12/14/2012 18:44:16
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class LivingObjectChangeSkinRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5725;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int livingUID;
    public short livingPosition;
    public int skinId;
    
    public LivingObjectChangeSkinRequestMessage() { }
    
    public LivingObjectChangeSkinRequestMessage(int livingUID, short livingPosition, int skinId) {
        this.livingUID = livingUID;
        this.livingPosition = livingPosition;
        this.skinId = skinId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(livingUID);
        writer.writeUnsignedByte(livingPosition);
        writer.writeInt(skinId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        livingUID = reader.readInt();
        if (livingUID < 0)
            throw new RuntimeException("Forbidden value on livingUID = " + livingUID + ", it doesn't respect the following condition : livingUID < 0");
        livingPosition = reader.readUnsignedByte();
        if (livingPosition < 0 || livingPosition > 255)
            throw new RuntimeException("Forbidden value on livingPosition = " + livingPosition + ", it doesn't respect the following condition : livingPosition < 0 || livingPosition > 255");
        skinId = reader.readInt();
        if (skinId < 0)
            throw new RuntimeException("Forbidden value on skinId = " + skinId + ", it doesn't respect the following condition : skinId < 0");
    }
    
}
