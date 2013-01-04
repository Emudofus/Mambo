

// Generated on 01/04/2013 14:54:24
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(mapRideId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        mapRideId = reader.readInt();
    }
    
}
