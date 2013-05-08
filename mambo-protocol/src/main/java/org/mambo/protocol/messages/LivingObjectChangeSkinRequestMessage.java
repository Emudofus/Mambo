

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeInt(livingUID);
        buf.writeUByte(livingPosition);
        buf.writeInt(skinId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        livingUID = buf.readInt();
        if (livingUID < 0)
            throw new RuntimeException("Forbidden value on livingUID = " + livingUID + ", it doesn't respect the following condition : livingUID < 0");
        livingPosition = buf.readUByte();
        if (livingPosition < 0 || livingPosition > 255)
            throw new RuntimeException("Forbidden value on livingPosition = " + livingPosition + ", it doesn't respect the following condition : livingPosition < 0 || livingPosition > 255");
        skinId = buf.readInt();
        if (skinId < 0)
            throw new RuntimeException("Forbidden value on skinId = " + skinId + ", it doesn't respect the following condition : skinId < 0");
    }
    
}
