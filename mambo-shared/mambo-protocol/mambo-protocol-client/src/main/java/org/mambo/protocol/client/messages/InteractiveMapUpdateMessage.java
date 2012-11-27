

// Generated on 11/11/2012 20:41:33
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
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
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        interactiveElements = new InteractiveElement[limit];
        for (int i = 0; i < limit; i++) {
            interactiveElements[i] = new InteractiveElement();
            interactiveElements[i].deserialize(reader);
        }
    }
    
}
