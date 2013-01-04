

// Generated on 01/04/2013 14:54:24
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

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
