

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MountXpRatioMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5970;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte ratio;
    
    public MountXpRatioMessage() { }
    
    public MountXpRatioMessage(byte ratio) {
        this.ratio = ratio;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(ratio);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        ratio = buf.readByte();
        if (ratio < 0)
            throw new RuntimeException("Forbidden value on ratio = " + ratio + ", it doesn't respect the following condition : ratio < 0");
    }
    
}
