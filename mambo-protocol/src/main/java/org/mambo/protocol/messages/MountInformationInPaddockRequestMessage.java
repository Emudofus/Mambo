

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MountInformationInPaddockRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5975;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int mapRideId;
    
    public MountInformationInPaddockRequestMessage() { }
    
    public MountInformationInPaddockRequestMessage(int mapRideId) {
        this.mapRideId = mapRideId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(mapRideId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        mapRideId = buf.readInt();
    }
    
}
