

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(parts.length);
        for (ContentPart entry : parts) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        parts = new ContentPart[limit];
        for (int i = 0; i < limit; i++) {
            parts[i] = new ContentPart();
            parts[i].deserialize(buf);
        }
    }
    
}
