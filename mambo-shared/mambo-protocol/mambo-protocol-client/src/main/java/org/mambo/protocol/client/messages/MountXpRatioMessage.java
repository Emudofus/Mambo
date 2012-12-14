

// Generated on 12/14/2012 18:44:07
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(ratio);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        ratio = reader.readByte();
        if (ratio < 0)
            throw new RuntimeException("Forbidden value on ratio = " + ratio + ", it doesn't respect the following condition : ratio < 0");
    }
    
}
