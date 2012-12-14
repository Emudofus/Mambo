

// Generated on 12/14/2012 18:44:18
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PartsListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1502;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ContentPart[] parts;
    
    public PartsListMessage() { }
    
    public PartsListMessage(ContentPart[] parts) {
        this.parts = parts;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(parts.length);
        for (ContentPart entry : parts) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        parts = new ContentPart[limit];
        for (int i = 0; i < limit; i++) {
            parts[i] = new ContentPart();
            parts[i].deserialize(reader);
        }
    }
    
}
