

// Generated on 12/14/2012 18:44:22
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ProtectedEntityWaitingForHelpInfo implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 186;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int timeLeftBeforeFight;
    public int waitTimeForPlacement;
    public byte nbPositionForDefensors;
    
    public ProtectedEntityWaitingForHelpInfo() { }
    
    public ProtectedEntityWaitingForHelpInfo(int timeLeftBeforeFight, int waitTimeForPlacement, byte nbPositionForDefensors) {
        this.timeLeftBeforeFight = timeLeftBeforeFight;
        this.waitTimeForPlacement = waitTimeForPlacement;
        this.nbPositionForDefensors = nbPositionForDefensors;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(timeLeftBeforeFight);
        writer.writeInt(waitTimeForPlacement);
        writer.writeByte(nbPositionForDefensors);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        timeLeftBeforeFight = reader.readInt();
        waitTimeForPlacement = reader.readInt();
        nbPositionForDefensors = reader.readByte();
        if (nbPositionForDefensors < 0)
            throw new RuntimeException("Forbidden value on nbPositionForDefensors = " + nbPositionForDefensors + ", it doesn't respect the following condition : nbPositionForDefensors < 0");
    }
    
}
