

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameMapChangeOrientationRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 945;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte direction;
    
    public GameMapChangeOrientationRequestMessage() { }
    
    public GameMapChangeOrientationRequestMessage(byte direction) {
        this.direction = direction;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(direction);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        direction = buf.readByte();
        if (direction < 0)
            throw new RuntimeException("Forbidden value on direction = " + direction + ", it doesn't respect the following condition : direction < 0");
    }
    
}
