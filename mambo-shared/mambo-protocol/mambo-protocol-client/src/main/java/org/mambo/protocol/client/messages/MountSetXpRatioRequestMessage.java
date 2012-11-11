

// Generated on 11/11/2012 19:17:02
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(xpRatio);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        xpRatio = reader.readByte();
        if (xpRatio < 0)
            throw new RuntimeException("Forbidden value on xpRatio = " + xpRatio + ", it doesn't respect the following condition : xpRatio < 0");
    }
    
}
