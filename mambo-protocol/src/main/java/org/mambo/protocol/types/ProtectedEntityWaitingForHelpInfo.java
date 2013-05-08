

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ProtectedEntityWaitingForHelpInfo extends NetworkType {
    public static final short TYPE_ID = 186;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeInt(timeLeftBeforeFight);
        buf.writeInt(waitTimeForPlacement);
        buf.writeByte(nbPositionForDefensors);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        timeLeftBeforeFight = buf.readInt();
        waitTimeForPlacement = buf.readInt();
        nbPositionForDefensors = buf.readByte();
        if (nbPositionForDefensors < 0)
            throw new RuntimeException("Forbidden value on nbPositionForDefensors = " + nbPositionForDefensors + ", it doesn't respect the following condition : nbPositionForDefensors < 0");
    }
    
}
