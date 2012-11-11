

// Generated on 11/11/2012 19:17:00
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameContextRemoveMultipleElementsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 252;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] id;
    
    public GameContextRemoveMultipleElementsMessage() { }
    
    public GameContextRemoveMultipleElementsMessage(int[] id) {
        this.id = id;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(id.length);
        for (int entry : id) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        id = new int[limit];
        for (int i = 0; i < limit; i++) {
            id[i] = reader.readInt();
        }
    }
    
}
