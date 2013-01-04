

// Generated on 01/04/2013 14:54:40
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AlignmentSubAreaUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6057;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short subAreaId;
    public byte side;
    public boolean quiet;
    
    public AlignmentSubAreaUpdateMessage() { }
    
    public AlignmentSubAreaUpdateMessage(short subAreaId, byte side, boolean quiet) {
        this.subAreaId = subAreaId;
        this.side = side;
        this.quiet = quiet;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(subAreaId);
        writer.writeByte(side);
        writer.writeBoolean(quiet);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        subAreaId = reader.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
        side = reader.readByte();
        quiet = reader.readBoolean();
    }
    
}
