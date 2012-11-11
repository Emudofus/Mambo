

// Generated on 11/11/2012 19:17:08
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class StatedMapUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5716;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public StatedElement[] statedElements;
    
    public StatedMapUpdateMessage() { }
    
    public StatedMapUpdateMessage(StatedElement[] statedElements) {
        this.statedElements = statedElements;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(statedElements.length);
        for (StatedElement entry : statedElements) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        statedElements = new StatedElement[limit];
        for (int i = 0; i < limit; i++) {
            statedElements[i] = new StatedElement();
            statedElements[i].deserialize(reader);
        }
    }
    
}
