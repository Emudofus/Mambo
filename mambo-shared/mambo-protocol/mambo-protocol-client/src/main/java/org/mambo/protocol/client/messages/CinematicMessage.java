

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class CinematicMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6053;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short cinematicId;
    
    public CinematicMessage() { }
    
    public CinematicMessage(short cinematicId) {
        this.cinematicId = cinematicId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(cinematicId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        cinematicId = reader.readShort();
        if (cinematicId < 0)
            throw new RuntimeException("Forbidden value on cinematicId = " + cinematicId + ", it doesn't respect the following condition : cinematicId < 0");
    }
    
}
