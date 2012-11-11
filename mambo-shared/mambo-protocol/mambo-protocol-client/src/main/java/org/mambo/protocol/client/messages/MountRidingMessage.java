

// Generated on 11/11/2012 19:17:02
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class MountRidingMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5967;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean isRiding;
    
    public MountRidingMessage() { }
    
    public MountRidingMessage(boolean isRiding) {
        this.isRiding = isRiding;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(isRiding);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        isRiding = reader.readBoolean();
    }
    
}
