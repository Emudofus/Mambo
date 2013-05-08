

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeShort(areaId);
        buf.writeByte(side);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        areaId = buf.readShort();
        if (areaId < 0)
            throw new RuntimeException("Forbidden value on areaId = " + areaId + ", it doesn't respect the following condition : areaId < 0");
        side = buf.readByte();
    }
    
}
