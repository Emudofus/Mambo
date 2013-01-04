

// Generated on 01/04/2013 14:54:40
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AlignmentAreaUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6060;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short areaId;
    public byte side;
    
    public AlignmentAreaUpdateMessage() { }
    
    public AlignmentAreaUpdateMessage(short areaId, byte side) {
        this.areaId = areaId;
        this.side = side;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(areaId);
        writer.writeByte(side);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        areaId = reader.readShort();
        if (areaId < 0)
            throw new RuntimeException("Forbidden value on areaId = " + areaId + ", it doesn't respect the following condition : areaId < 0");
        side = reader.readByte();
    }
    
}
