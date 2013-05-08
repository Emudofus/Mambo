

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MountSetXpRatioRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5989;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte xpRatio;
    
    public MountSetXpRatioRequestMessage() { }
    
    public MountSetXpRatioRequestMessage(byte xpRatio) {
        this.xpRatio = xpRatio;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(xpRatio);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        xpRatio = buf.readByte();
        if (xpRatio < 0)
            throw new RuntimeException("Forbidden value on xpRatio = " + xpRatio + ", it doesn't respect the following condition : xpRatio < 0");
    }
    
}
