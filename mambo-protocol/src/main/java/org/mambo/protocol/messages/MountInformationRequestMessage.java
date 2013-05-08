

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeDouble(id);
        buf.writeDouble(time);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        id = buf.readDouble();
        time = buf.readDouble();
    }
    
}
