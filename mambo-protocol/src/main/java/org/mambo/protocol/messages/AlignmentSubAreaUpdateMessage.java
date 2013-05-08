

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeShort(subAreaId);
        buf.writeByte(side);
        buf.writeBoolean(quiet);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        subAreaId = buf.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
        side = buf.readByte();
        quiet = buf.readBoolean();
    }
    
}
