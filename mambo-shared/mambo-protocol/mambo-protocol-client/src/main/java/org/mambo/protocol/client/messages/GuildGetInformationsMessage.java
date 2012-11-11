

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GuildGetInformationsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5550;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte infoType;
    
    public GuildGetInformationsMessage() { }
    
    public GuildGetInformationsMessage(byte infoType) {
        this.infoType = infoType;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(infoType);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        infoType = reader.readByte();
        if (infoType < 0)
            throw new RuntimeException("Forbidden value on infoType = " + infoType + ", it doesn't respect the following condition : infoType < 0");
    }
    
}
