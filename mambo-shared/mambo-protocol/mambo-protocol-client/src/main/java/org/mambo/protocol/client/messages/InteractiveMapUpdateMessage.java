

// Generated on 12/14/2012 18:44:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class InteractiveMapUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5002;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public InteractiveElement[] interactiveElements;
    
    public InteractiveMapUpdateMessage() { }
    
    public InteractiveMapUpdateMessage(InteractiveElement[] interactiveElements) {
        this.interactiveElements = interactiveElements;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(interactiveElements.length);
        for (InteractiveElement entry : interactiveElements) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        interactiveElements = new InteractiveElement[limit];
        for (int i = 0; i < limit; i++) {
            interactiveElements[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), InteractiveElement.class);
            interactiveElements[i].deserialize(reader);
        }
    }
    
}
