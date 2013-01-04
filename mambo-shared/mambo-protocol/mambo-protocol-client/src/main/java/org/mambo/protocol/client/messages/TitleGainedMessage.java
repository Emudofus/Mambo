

// Generated on 01/04/2013 14:54:41
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class TitleGainedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6364;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short titleId;
    
    public TitleGainedMessage() { }
    
    public TitleGainedMessage(short titleId) {
        this.titleId = titleId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(titleId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        titleId = reader.readShort();
        if (titleId < 0)
            throw new RuntimeException("Forbidden value on titleId = " + titleId + ", it doesn't respect the following condition : titleId < 0");
    }
    
}
