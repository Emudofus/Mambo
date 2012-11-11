

// Generated on 11/11/2012 19:17:02
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class MountInformationRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5972;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double id;
    public double time;
    
    public MountInformationRequestMessage() { }
    
    public MountInformationRequestMessage(double id, double time) {
        this.id = id;
        this.time = time;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeDouble(id);
        writer.writeDouble(time);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readDouble();
        time = reader.readDouble();
    }
    
}
